package com.codexive.personalorganiser.custom;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.codexive.personalorganiser.Helper.DateHelper;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.ui.fragment.todo.CallBackPopUp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToDoAlertDialog extends DialogFragment {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.et_dialog_taskname)
    EditText etDialogTaskname;
    @BindView(R.id.et_dialog_location)
    EditText etDialogLocation;
    @BindView(R.id.tv_dialog_status)
    TextView tvDialogStatus;
    @BindView(R.id.btn_complete)
    RelativeLayout btnComplete;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.cancel)
    Button cancel;

    boolean status = false;

    public ToDoAlertDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ToDoAlertDialog newInstance(String title) {
        ToDoAlertDialog frag = new ToDoAlertDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.popup_todo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        etDialogTaskname.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        tvDate.setText(DateHelper.getCurrentDate());


    }

    @OnClick({R.id.btn_complete, R.id.add, R.id.cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
                if(status){
                    btnComplete.setBackground(getActivity().getDrawable(R.drawable.style_curve_not_complete));
                    status = false;
                    tvDialogStatus.setText("Not Completed");
                }else {
                    btnComplete.setBackground(getActivity().getDrawable(R.drawable.style_curve_complete));
                    tvDialogStatus.setText("Completed");
                    status = true;
                }
                break;
            case R.id.add:
                sendBackResult();
                break;
            case R.id.cancel:
                getDialog().dismiss();
                break;
        }
    }

    public void sendBackResult() {
        CallBackPopUp callBackPopUp = (CallBackPopUp) getTargetFragment();
        callBackPopUp.popUpResult(etDialogTaskname.getText().toString(),etDialogLocation.getText().toString(),tvDate.getText().toString(), status);
        dismiss();
    }

}
