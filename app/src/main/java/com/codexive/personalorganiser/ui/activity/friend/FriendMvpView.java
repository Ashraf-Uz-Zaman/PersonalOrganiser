package com.codexive.personalorganiser.ui.activity.friend;

import com.codexive.personalorganiser.ui.base.MvpView;

public interface FriendMvpView extends MvpView {
    void sucessToStore(String mes);
    void unSucessToStore(String mes);
}
