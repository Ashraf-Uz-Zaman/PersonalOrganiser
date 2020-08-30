package com.codexive.personalorganiser.ui.fragment.todo;

import com.codexive.personalorganiser.ui.base.MvpPresenter;

public interface ToDoMvpPresenter<V extends ToDoMvpView> extends MvpPresenter<V> {
    void onAddData(String taskName, String location, String date, boolean status);
    void onGetData();
}
