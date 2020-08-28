package com.codexive.personalorganiser.ui.fragment.gallery;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.adapter.GalleryAdapter;
import com.codexive.personalorganiser.custom.RecyclerViewGriditemDecoration;
import com.codexive.personalorganiser.di.component.ActivityComponent;
import com.codexive.personalorganiser.ui.base.BaseFragment;
import com.codexive.personalorganiser.utils.CommonUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;


public class GalleryFragment extends BaseFragment implements GalleryMvpView, View.OnLongClickListener {

    @Inject
    GalleryAdapter galleryAdapter;
    @Inject
    GalleryMvpPresenter<GalleryMvpView> mPresenter;

    @BindView(R.id.floatActionButton_Camera)
    FloatingActionButton floatActionButtonCamera;
    @BindView(R.id.rv_gallery)
    RecyclerView rvGallery;
    @BindView(R.id.fragment_gallery)
    FrameLayout fragmentGallery;

    private String TAG = "GalleryFragment";
    public static final int REQUEST_CODE_CAMERA = 0012;
    public static final int REQUEST_CODE_GALLERY = 0013;
    private String pathFile = null;

    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance() {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected void setUp(View view) {
        floatActionButtonCamera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e("sdfsdfsadf", "Longpress detected");
                return false;
            }
        });
        pathFile = "/sdcard/" + getString(R.string.storage_name) + "/" + "image";
        rvGallery.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvGallery.addItemDecoration(new RecyclerViewGriditemDecoration(10, 10, 10, 10));
        rvGallery.setAdapter(galleryAdapter);
        galleryAdapter.setData(imageItems(CommonUtils.galleryDirectory));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            ButterKnife.bind(this, view);
            mPresenter.onAttach(this);
        }
        return view;
    }


    @OnClick(R.id.floatActionButton_Camera)
    public void onViewClicked() {
        requestMultiplePermission();
    }

    private void requestMultiplePermission() {
        Dexter.withContext(getContext()).withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {
                            selectImage(getContext());
                        }
                        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {

                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).onSameThread()
                .check();
    }

    private void selectImage(Context context) {
        final CharSequence[] options = {getString(R.string.take_photo), getString(R.string.choose_from_gallery), getString(R.string.cancel)};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(getString(R.string.choose_your_picture));
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals(getString(R.string.take_photo))) {
                    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, REQUEST_CODE_CAMERA);

                } else if (options[item].equals(getString(R.string.choose_from_gallery))) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, REQUEST_CODE_GALLERY);//one can be replaced with any action code

                } else if (options[item].equals(R.string.cancel)) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CAMERA:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        mPresenter.onStoreImage(bitmap);
                    }
                    break;
                case REQUEST_CODE_GALLERY:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        try {
                            InputStream imageStream;
                            imageStream = getContext().getContentResolver().openInputStream(selectedImage);
                            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                            mPresenter.onStoreImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    }


    private List<String> imageItems(String directoryPath) {
        List<String> items = new ArrayList<String>();

        // List all the items within the folder.
        File[] files = new File(directoryPath).listFiles(new ImageFileFilter());
        for (File file : files) {
            items.add(file.getAbsolutePath());
        }

        return items;
    }


    @Override
    public void sucessToAdmitList() {

    }

    @Override
    public void sucessToStore(String message) {
        showMessage(message);
        galleryAdapter.setData(imageItems(CommonUtils.galleryDirectory));
    }

    @Override
    public void sucessToDelete() {

    }

    @Override
    public void unSucessToAdmitList() {

    }

    @Override
    public void unSucessToStore(String message) {
        onError(message);
    }

    @Override
    public void unSucessToDelete() {

    }

    final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        public void onLongPress(MotionEvent e) {
            Log.e("", "Longpress detected");
        }
    });


//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        return gestureDetector.onTouchEvent(motionEvent);
//    }

    @Override
    public boolean onLongClick(View view) {
        Log.e("", "Longpress detected");
        return true;
    }
}