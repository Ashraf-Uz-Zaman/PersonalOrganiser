package com.codexive.personalorganiser.ui.fragment.gallery;

import android.content.Context;
import android.graphics.Bitmap;

import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface GalleryMvpPresenter <V extends GalleryMvpView> extends MvpPresenter<V> {
    void onStoreImage(Bitmap bitmap, Context context);
    void onDeleteImage();
}
