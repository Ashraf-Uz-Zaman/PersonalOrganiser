package com.codexive.personalorganiser.ui.fragment.friend;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.adapter.FriendsAdapter;
import com.codexive.personalorganiser.custom.RecyclerViewGriditemDecoration;
import com.codexive.personalorganiser.custom.RecyclerViewVerticalDecoration;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.di.component.ActivityComponent;
import com.codexive.personalorganiser.ui.activity.friend.FriendActivity;
import com.codexive.personalorganiser.ui.base.BaseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FriendsFragment extends BaseFragment implements FriendsMvpView {

    @Inject
    FriendsAdapter friendsAdapter;
    @Inject
    FriendsMvpPresenter<FriendsMvpView> mPresenter;

    @BindView(R.id.floatActionButton_friend)
    FloatingActionButton floatActionButtonFriend;
    @BindView(R.id.rv_frined)
    RecyclerView rvFrined;

    public FriendsFragment() {
        // Required empty public constructor
    }

    public static FriendsFragment newInstance() {
        FriendsFragment fragment = new FriendsFragment();
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
        rvFrined.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFrined.addItemDecoration(new RecyclerViewVerticalDecoration(10));
        rvFrined.setAdapter(friendsAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            ButterKnife.bind(this, view);
            mPresenter.onAttach(this);
        }
        return view;
    }

    @OnClick(R.id.floatActionButton_friend)
    public void onViewClicked() {
        startActivity(FriendActivity.getStartIntent(getContext()).putExtra("condition",getString(R.string.saving)));
    }

    @Override
    public void sucessToAdmit(List<FriendModel> friendModels) {
        friendsAdapter.setData(friendModels);
    }

    @Override
    public void unSucessToAdmit(String mes) {
        showMessage(mes);
        friendsAdapter.clearData();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onGetData();
    }
}