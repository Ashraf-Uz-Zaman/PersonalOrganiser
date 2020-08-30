package com.codexive.personalorganiser.ui.activity.todo;


import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.MvpView;

import java.util.List;

public interface ToDosMvpView extends MvpView {
    void sucessToAdmit(String mes);
    void unSucessToAdmit(String mes);

}
