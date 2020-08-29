package com.codexive.personalorganiser.ui.fragment.friend;

import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.ui.base.MvpView;

import java.util.List;

public interface FriendsMvpView extends MvpView {
    void sucessToAdmit(List<FriendModel> friendModels);
    void unSucessToAdmit(String mes);
}
