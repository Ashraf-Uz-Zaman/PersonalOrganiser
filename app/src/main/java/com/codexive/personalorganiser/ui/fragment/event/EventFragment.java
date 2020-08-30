package com.codexive.personalorganiser.ui.fragment.event;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.adapter.EventAdapter;
import com.codexive.personalorganiser.custom.RecyclerViewVerticalDecoration;
import com.codexive.personalorganiser.custom.ToDoAlertDialog;
import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.di.component.ActivityComponent;
import com.codexive.personalorganiser.ui.base.BaseFragment;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventFragment extends BaseFragment implements EventMvpView, CallBackEventPopUP {

    @Inject
    EventMvpPresenter<EventMvpView> mPresenter;

    @Inject
    EventAdapter eventAdapter;

    @BindView(R.id.rv_event)
    RecyclerView rvEvent;

    public EventFragment() {
        // Required empty public constructor
    }

    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
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
        rvEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEvent.addItemDecoration(new RecyclerViewVerticalDecoration(20));
        rvEvent.setAdapter(eventAdapter);
        eventAdapter.setListener(new EventAdapter.EventClick() {
            @Override
            public void OnDelete(EventModel eventModel) {
                mPresenter.onDeleteData(eventModel);
            }
        });
        mPresenter.onGetData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
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
        showDialog();
    }

    private void showDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        EventAlertDialog eventAlertDialog = EventAlertDialog.newInstance("Add Event");
        eventAlertDialog.setTargetFragment(EventFragment.this, 300);
        eventAlertDialog.show(fm, "EventAlertDialog");
    }

    @Override
    public void popUpResult(String name, String location, String date, String time) {
        mPresenter.onAddData(name, location, date, time);
    }

    @Override
    public void sucessToAdmitData(List<EventModel> list) {
        eventAdapter.setData(list);
    }

    @Override
    public void sucessToAdmit(String mes) {
        showMessage(mes);
        mPresenter.onGetData();
    }

    @Override
    public void unSucessToAdmit(String mes) {
        showMessage(mes);
    }
}