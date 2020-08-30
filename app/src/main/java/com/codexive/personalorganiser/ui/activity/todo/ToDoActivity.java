package com.codexive.personalorganiser.ui.activity.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpPresenter;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpView;
import com.codexive.personalorganiser.ui.base.BaseActivity;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoActivity extends BaseActivity implements ToDosMvpView{

    @Inject
    ToDosMvpPresenter<ToDosMvpView> mPresenter;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.btn_menu)
    RelativeLayout btnMenu;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_friend)
    ImageView ivFriend;
    @BindView(R.id.et_taskName)
    EditText etTaskName;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.tv_dialog_status)
    TextView tvDialogStatus;
    @BindView(R.id.btn_complete)
    RelativeLayout btnComplete;
    @BindView(R.id.ll_details)
    LinearLayout llDetails;
    @BindView(R.id.relative_layout_profile)
    RelativeLayout relativeLayoutProfile;
    @BindView(R.id.rl_content)
    RelativeLayout rlContent;
    @BindView(R.id.btn_friend)
    Button btnFriend;
    @BindView(R.id.btn_layout)
    LinearLayout btnLayout;
    long id;
    boolean status = false;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ToDoActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        ButterKnife.bind(this);
        tvToolbar.setVisibility(View.GONE);
        toolbarTitle.setText("ToDo");
        toolbarTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.VISIBLE);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {
        etTaskName.setText(getIntent().getStringExtra("taskname"));
        etAddress.setText(getIntent().getStringExtra("location"));
        id = getIntent().getLongExtra("id", 0);
        status = getIntent().getBooleanExtra("status", false);
        if (status) {
            btnComplete.setBackground(getDrawable(R.drawable.style_curve_complete));
            tvDialogStatus.setText("Completed");

        } else {
            btnComplete.setBackground(getDrawable(R.drawable.style_curve_not_complete));
            tvDialogStatus.setText("Not Completed");
        }



    }

    @OnClick({R.id.img_back, R.id.btn_complete, R.id.btn_friend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.btn_complete:
                if (status) {
                    btnComplete.setBackground(getDrawable(R.drawable.style_curve_not_complete));
                    status = false;
                    tvDialogStatus.setText("Not Completed");
                } else {
                    btnComplete.setBackground(getDrawable(R.drawable.style_curve_complete));
                    tvDialogStatus.setText("Completed");
                    status = true;
                }
                break;
            case R.id.btn_friend:
                mPresenter.onUpdateData(id,etTaskName.getText().toString(),etAddress.getText().toString(),getIntent().getStringExtra("date").toString(),status);
                break;
        }
    }

    @Override
    public void sucessToAdmit(String mes) {
        showMessage(mes);
    }

    @Override
    public void unSucessToAdmit(String mes) {

    }


}