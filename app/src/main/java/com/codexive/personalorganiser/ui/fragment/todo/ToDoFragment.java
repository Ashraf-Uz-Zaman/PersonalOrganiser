package com.codexive.personalorganiser.ui.fragment.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.adapter.ToDoCompleteAdapter;
import com.codexive.personalorganiser.adapter.ToDoNotCompleteAdapter;
import com.codexive.personalorganiser.custom.RecyclerViewHorizontalDecoration;
import com.codexive.personalorganiser.custom.ToDoAlertDialog;
import com.codexive.personalorganiser.data.db.models.ToDoCompleteModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.data.db.models.ToDoNotCompleteModel;
import com.codexive.personalorganiser.di.component.ActivityComponent;
import com.codexive.personalorganiser.ui.base.BaseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoFragment extends BaseFragment implements ToDoMvpView, CallBackPopUp {

    @Inject
    ToDoNotCompleteAdapter toDoNotCompleteAdapter;
    @Inject
    ToDoCompleteAdapter toDoCompleteAdapter;
    @Inject
    ToDoMvpPresenter<ToDoMvpView> mPresenter;
    @BindView(R.id.rv_todo)
    RecyclerView rvTodo;
    @BindView(R.id.floatActionButton_todo)
    FloatingActionButton floatActionButtonTodo;
    @BindView(R.id.rv_todo_not)
    RecyclerView rvTodoNot;

    public ToDoFragment() {
        // Required empty public constructor
    }


    public static ToDoFragment newInstance() {
        ToDoFragment fragment = new ToDoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected void setUp(View view) {
        rvTodo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rvTodo.addItemDecoration(new RecyclerViewHorizontalDecoration(10));
        rvTodo.setAdapter(toDoCompleteAdapter);

        rvTodoNot.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rvTodoNot.addItemDecoration(new RecyclerViewHorizontalDecoration(10));
        rvTodoNot.setAdapter(toDoNotCompleteAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            ButterKnife.bind(this, view);
            mPresenter.onAttach(this);
        }
        return view;
    }

    @OnClick(R.id.floatActionButton_todo)
    public void onViewClicked() {
        showTodoDialog();
    }

    private void showTodoDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        ToDoAlertDialog toDoAlertDialog = ToDoAlertDialog.newInstance("Add Task");
        toDoAlertDialog.setTargetFragment(ToDoFragment.this, 300);
        toDoAlertDialog.show(fm, "fragment_edit_name");

    }

    @Override
    public void popUpResult(String taskName, String location, String date, boolean status) {
        mPresenter.onAddData(taskName, location, date, status);
    }

    @Override
    public void sucessToAdmit(String mes) {
        showMessage(mes);
        mPresenter.onGetData();
    }

    @Override
    public void unSucessToAdmit(String mes) {

    }

    @Override
    public void sucessToAdmitData(List<ToDoModel> list) {
        List<ToDoNotCompleteModel> todoNotCompleteList = new ArrayList<>();
        List<ToDoCompleteModel> todoCompleteList = new ArrayList<>();

        for(int i = 0; i<list.size();i++){
            if(list.get(i).getTodo_status()){
                todoCompleteList.add(new ToDoCompleteModel(list.get(i).getId(),list.get(i).getTodo_taskName(),list.get(i).getTodo_location(),list.get(i).getTodo_date(),list.get(i).getTodo_status()));
            }else {
                todoNotCompleteList.add(new ToDoNotCompleteModel(list.get(i).getId(),list.get(i).getTodo_taskName(),list.get(i).getTodo_location(),list.get(i).getTodo_date(),list.get(i).getTodo_status()));
            }
        }
        toDoCompleteAdapter.setData(todoCompleteList);
        toDoNotCompleteAdapter.setData(todoNotCompleteList);

    }

    @Override
    public void unSucessToAdmitData(String mes) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onGetData();
    }
}