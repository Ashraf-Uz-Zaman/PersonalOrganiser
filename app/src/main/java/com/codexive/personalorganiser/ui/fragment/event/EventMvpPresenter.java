package com.codexive.personalorganiser.ui.fragment.event;

import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface EventMvpPresenter<V extends EventMvpView> extends MvpPresenter<V> {
    void onAddData(String name, String location, String date, String time);

    void onGetData();

    void onDeleteData(EventModel eventModel);
}
