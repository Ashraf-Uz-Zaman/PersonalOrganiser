package com.codexive.personalorganiser.ui.fragment.gallery;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.ui.base.BasePresenter;
import com.codexive.personalorganiser.utils.CommonUtils;

import java.io.File;
import java.io.FileOutputStream;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GalleryPresenter <V extends GalleryMvpView> extends BasePresenter<V> implements GalleryMvpPresenter<V>{

    @Inject
    public GalleryPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }

    @Override
    public void onStoreImage(Bitmap bitmap, Context context) {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.saving));
        File fileFolder = new File(Environment.getExternalStorageDirectory()+ CommonUtils.galleryDirectory);
        boolean success = true;
        if(!fileFolder.exists()) {
            fileFolder.mkdir();
        }

        File file = new File(new File(Environment.getExternalStorageDirectory()+ CommonUtils.galleryDirectory), System.currentTimeMillis() + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            getMvpView().hideLoading();
            getMvpView().sucessToStore(getMvpView().getContext().getString(R.string.stored));
        } catch (Exception e) {
            getMvpView().hideLoading();
            Log.e("DATALINK", "onStoreImage: "+e.getMessage() );
            getMvpView().unSucessToStore(getMvpView().getContext().getString(R.string.error_stored));
            e.printStackTrace();
        }
    }

    @Override
    public void onDeleteImage() {

    }
}
