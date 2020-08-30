package com.codexive.personalorganiser.ui.fragment.event;

import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.MvpView;

import java.util.List;

public interface EventMvpView extends MvpView {

    void sucessToAdmitData(List<EventModel> list);

    void sucessToAdmit(String mes);

    void unSucessToAdmit(String mes);
}
