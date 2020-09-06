package com.codexive.personalorganiser.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.codexive.personalorganiser.adapter.EventAdapter;
import com.codexive.personalorganiser.adapter.FriendsAdapter;
import com.codexive.personalorganiser.adapter.GalleryAdapter;
import com.codexive.personalorganiser.adapter.ToDoCompleteAdapter;
import com.codexive.personalorganiser.adapter.ToDoNotCompleteAdapter;
import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.data.db.models.ToDoCompleteModel;
import com.codexive.personalorganiser.data.db.models.ToDoNotCompleteModel;
import com.codexive.personalorganiser.di.ActivityContext;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpPresenter;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpView;
import com.codexive.personalorganiser.ui.activity.friend.FriendPresenter;
import com.codexive.personalorganiser.ui.activity.todo.ToDosMvpPresenter;
import com.codexive.personalorganiser.ui.activity.todo.ToDosMvpView;
import com.codexive.personalorganiser.ui.activity.todo.ToDosPresenter;
import com.codexive.personalorganiser.ui.fragment.event.EventMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.event.EventMvpView;
import com.codexive.personalorganiser.ui.fragment.event.EventPresenter;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsMvpView;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsPresenter;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryMvpView;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryPresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpView;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoPresenter;

import java.util.ArrayList;

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

    @Provides
    ToDoMvpPresenter<ToDoMvpView> provideToDoMpvPresenter(
            ToDoPresenter<ToDoMvpView> presenter) {
        return presenter;
    }
    @Provides
    ToDosMvpPresenter<ToDosMvpView> provideToDosMpvPresenter(
            ToDosPresenter<ToDosMvpView> presenter) {
        return presenter;
    }

    @Provides
    EventMvpPresenter<EventMvpView> provideEventMvpPresenter(
            EventPresenter<EventMvpView> presenter) {
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


    @Provides
    ToDoNotCompleteAdapter provideToDoNotCompleteAdapter() {
        return new ToDoNotCompleteAdapter(mActivity, new ArrayList<ToDoNotCompleteModel>());
    }

    @Provides
    ToDoCompleteAdapter provideToDoCompleteAdapter() {
        return new ToDoCompleteAdapter(mActivity, new ArrayList<ToDoCompleteModel>());
    }

    @Provides
    EventAdapter provideEventAdapter() {
        return new EventAdapter(mActivity, new ArrayList<EventModel>());
    }

}
