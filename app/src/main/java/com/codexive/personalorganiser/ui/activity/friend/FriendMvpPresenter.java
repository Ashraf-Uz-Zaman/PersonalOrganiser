package com.codexive.personalorganiser.ui.activity.friend;

import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface FriendMvpPresenter <V extends FriendMvpView> extends MvpPresenter<V> {
    void onStoreData(String firstName, String lastName, String gender, String Age, String Address);
}
