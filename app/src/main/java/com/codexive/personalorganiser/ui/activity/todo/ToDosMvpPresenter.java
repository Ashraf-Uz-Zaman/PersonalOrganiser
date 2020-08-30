package com.codexive.personalorganiser.ui.activity.todo;

import com.codexive.personalorganiser.ui.base.MvpPresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpView;

public interface ToDosMvpPresenter<V extends ToDosMvpView> extends MvpPresenter<V> {
    void onUpdateData(Long Id,String taskName, String location, String date, boolean status);
}
