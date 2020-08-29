package com.codexive.personalorganiser.ui.fragment.friend;

import com.codexive.personalorganiser.ui.activity.friend.FriendMvpView;
import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface FriendsMvpPresenter<V extends FriendsMvpView> extends MvpPresenter<V> {
    void onGetData();
}
