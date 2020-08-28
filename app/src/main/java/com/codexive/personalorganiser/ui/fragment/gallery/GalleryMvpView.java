package com.codexive.personalorganiser.ui.fragment.gallery;

import com.codexive.personalorganiser.ui.base.MvpView;

public interface GalleryMvpView extends MvpView {
    void sucessToAdmitList();
    void sucessToStore(String message);
    void sucessToDelete();

    void unSucessToAdmitList();
    void unSucessToStore(String message);
    void unSucessToDelete();
}
