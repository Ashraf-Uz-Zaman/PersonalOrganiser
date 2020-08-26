package com.codexive.personalorganiser.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.codexive.personalorganiser.di.ActivityContext;

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


    // Presenter Activity
//    @Provides
//    @PerActivity
//    LoginMvpPresenter<LoginMvpView> provideLoginMpvPresenter(
//            LoginPresenter<LoginMvpView> presenter) {
//        return presenter;
//    }


    // Adapter

//    @Provides
//    HomeSlideAdapter provideHomeSlideAdapter() {
//        return new HomeSlideAdapter(mActivity, new HomeResponse());
//    }


}
