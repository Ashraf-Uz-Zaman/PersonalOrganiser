package com.codexive.personalorganiser.ui.fragment.gallery;

import android.graphics.Bitmap;

import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface GalleryMvpPresenter <V extends GalleryMvpView> extends MvpPresenter<V> {
    void onStoreImage(Bitmap bitmap);
    void onDeleteImage();
}
