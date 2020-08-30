package com.codexive.personalorganiser.ui.activity.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendActivity extends BaseActivity implements FriendMvpView, RadioGroup.OnCheckedChangeListener {

    @Inject
    FriendMvpPresenter<FriendMvpView> mPresenter;

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
    @BindView(R.id.et_firstname)
    EditText etFirstname;
    @BindView(R.id.et_lastname)
    EditText etLastname;
    @BindView(R.id.radioMale)
    RadioButton radioMale;
    @BindView(R.id.radioFemale)
    RadioButton radioFemale;
    @BindView(R.id.radioGrp)
    RadioGroup radioGrp;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.rl_content)
    RelativeLayout rlContent;
    @BindView(R.id.ll_details)
    LinearLayout llDetails;
    @BindView(R.id.relative_layout_profile)
    RelativeLayout relativeLayoutProfile;
    @BindView(R.id.btn_friend)
    Button btnFriend;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.layout_update_delete)
    LinearLayout layoutUpdateDelete;
    @BindView(R.id.btn_layout)
    LinearLayout btnLayout;

    String gender = "Male";
    String condition = "";
    long id = 0;



    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, FriendActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        condition = getIntent().getStringExtra("condition");
        setUp();
    }

    @Override
    protected void setUp() {
        radioGrp.setOnCheckedChangeListener(this);
        tvToolbar.setVisibility(View.GONE);
        toolbarTitle.setText("Friend Information");
        toolbarTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.VISIBLE);
        if (condition.equals(getString(R.string.saving))) {
            layoutUpdateDelete.setVisibility(View.GONE);
            btnFriend.setVisibility(View.VISIBLE);

        } else if (condition.equals(getString(R.string.updated))) {
            layoutUpdateDelete.setVisibility(View.VISIBLE);
            btnFriend.setVisibility(View.GONE);
            etFirstname.setText(getIntent().getStringExtra("firstname"));
            etLastname.setText(getIntent().getStringExtra("lastname"));
            etAddress.setText(getIntent().getStringExtra("location"));
            etAge.setText(getIntent().getStringExtra("age"));
            if ("Male".equals(getIntent().getStringExtra("gender"))) {
                radioMale.toggle();
            } else if ("Female".equals(getIntent().getStringExtra("gender"))) {
                radioFemale.toggle();
            }
            id = getIntent().getLongExtra("id", 0);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radioMale:
                gender = "Male";
                break;
            case R.id.radioFemale:
                gender = "Female";
                break;
        }
    }

    @OnClick({R.id.img_back, R.id.btn_friend,R.id.btn_update,R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.btn_friend:
                if(emptyStringCheck(etFirstname.getText().toString()) && emptyStringCheck(etLastname.getText().toString())&& emptyStringCheck(etAge.getText().toString())&& emptyStringCheck(etAddress.getText().toString())) {
                    mPresenter.onStoreData(etFirstname.getText().toString(), etLastname.getText().toString(), gender, etAge.getText().toString(), etAddress.getText().toString());
                }else {
                    onError("Field should not be empty !");
                }
                break;
            case R.id.btn_delete:
                if(emptyStringCheck(etFirstname.getText().toString()) && emptyStringCheck(etLastname.getText().toString())&& emptyStringCheck(etAge.getText().toString())&& emptyStringCheck(etAddress.getText().toString())) {
                    mPresenter.onDeleteData(id, etFirstname.getText().toString(), etLastname.getText().toString(), gender, etAge.getText().toString(), etAddress.getText().toString());
                }else {
                    onError("Data changed. Do you want to update ?!");
                }
                break;
            case R.id.btn_update:
                if(emptyStringCheck(etFirstname.getText().toString()) && emptyStringCheck(etLastname.getText().toString())&& emptyStringCheck(etAge.getText().toString())&& emptyStringCheck(etAddress.getText().toString())) {
                    mPresenter.onUpdateData(id, etFirstname.getText().toString(), etLastname.getText().toString(), gender, etAge.getText().toString(), etAddress.getText().toString());
                }else {
                    onError("Field should not be empty !");
                }
                break;
        }
    }

    @Override
    public void sucessToStore(String mes) {
        showMessage(mes);
    }

    @Override
    public void unSucessToStore(String mes) {
        showMessage(mes);
    }

    @Override
    public void sucessToUpdate(String mes) {
        showMessage(mes);
    }

    @Override
    public void unSucessToUpdate(String mes) {
        showMessage(mes);
    }

    @Override
    public void sucessToDelete(String mes) {
        showMessage(mes);
        onBackPressed();
    }

    @Override
    public void unSucessToDelete(String mes) {
        showMessage(mes);
    }

    private boolean emptyStringCheck(String error) {
        if (error == null || error.equals("null") || error.equals("")) {
            return false;
        } else return true;
    }



}