package com.codexive.personalorganiser.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.codexive.personalorganiser.adapter.GalleryAdapter;
import com.codexive.personalorganiser.di.ActivityContext;
import com.codexive.personalorganiser.di.PerActivity;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryMvpView;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

//    TODO: Presenter

    @Provides
    GalleryMvpPresenter<GalleryMvpView> provideGalleryMpvPresenter(
            GalleryPresenter<GalleryMvpView> presenter) {
        return presenter;
    }

    // Presenter Activity
//    @Provides
//    @PerActivity
//    LoginMvpPresenter<LoginMvpView> provideLoginMpvPresenter(
//            LoginPresenter<LoginMvpView> presenter) {
//        return presenter;
//    }


//     TODO: Adapter

    @Provides
    GalleryAdapter provideGalleryAdapter() {
        return new GalleryAdapter(mActivity, new ArrayList<String>());
    }

}
