package com.codexive.personalorganiser.ui.fragment.todo;


import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.MvpView;

import java.util.List;

public interface ToDoMvpView extends MvpView {
    void sucessToAdmit(String mes);
    void unSucessToAdmit(String mes);

    void sucessToAdmitData(List<ToDoModel> list);
    void unSucessToAdmitData(String mes);
}
