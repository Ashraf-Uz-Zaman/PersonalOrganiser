package com.codexive.personalorganiser.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.codexive.personalorganiser.adapter.FriendsAdapter;
import com.codexive.personalorganiser.adapter.GalleryAdapter;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.di.ActivityContext;
import com.codexive.personalorganiser.di.PerActivity;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpPresenter;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpView;
import com.codexive.personalorganiser.ui.activity.friend.FriendPresenter;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsMvpView;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsPresenter;
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

    @Provides
    FriendMvpPresenter<FriendMvpView> provideFriendMpvPresenter(
            FriendPresenter<FriendMvpView> presenter) {
        return presenter;
    }

    @Provides
    FriendsMvpPresenter<FriendsMvpView> provideFriendsMpvPresenter(
            FriendsPresenter<FriendsMvpView> presenter) {
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

    @Provides
    FriendsAdapter provideFriendsAdapter() {
        return new FriendsAdapter(mActivity, new ArrayList<FriendModel>());
    }

}
