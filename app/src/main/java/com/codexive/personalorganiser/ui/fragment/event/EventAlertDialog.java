package com.codexive.personalorganiser.ui.fragment.event;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.custom.ToDoAlertDialog;
import com.codexive.personalorganiser.ui.fragment.todo.CallBackPopUp;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventAlertDialog extends DialogFragment {

    boolean status = false;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.et_dialog_taskname)
    EditText etDialogTaskname;
    @BindView(R.id.et_dialog_location)
    EditText etDialogLocation;
    @BindView(R.id.et_event_date)
    TextView etEventDate;
    @BindView(R.id.et_event_time)
    TextView etEventTime;

    //TODO: Date
    final Calendar cldr = Calendar.getInstance();
    int dayLimit = 0;
    int subLeaveDay = 0;
    int day = cldr.get(Calendar.DAY_OF_MONTH);
    int dayTo = cldr.get(Calendar.DAY_OF_MONTH);
    int month = cldr.get(Calendar.MONTH);
    int year = cldr.get(Calendar.YEAR);
    Calendar min_date_c = Calendar.getInstance();
    Calendar max_date_c = Calendar.getInstance();
    DatePickerDialog datePickerDialog, datePickerDialogTwo, datePickerDialogThree, datePickerDialogFour;
    String mSelectedToDate;
    String aTime;

    public EventAlertDialog() {
    }

    public static EventAlertDialog newInstance(String title) {
        EventAlertDialog frag = new EventAlertDialog();
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
        View view = inflater.inflate(R.layout.popup_event, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
//        etDialogTaskname.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //tvDate.setText(DateHelper.getCurrentDate());


    }

    @OnClick({R.id.add, R.id.cancel, R.id.et_event_date, R.id.et_event_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                sendBackResult();
                break;
            case R.id.cancel:
                getDialog().dismiss();
                break;
            case R.id.et_event_date:
                datePickerDialog = DatePickerDialog.newInstance((view1, year1, monthOfYear, dayOfMonth) -> {
                    if ((monthOfYear + 1) < 10) {
                        if (dayOfMonth < 10) {
                            mSelectedToDate = "0" + dayOfMonth + "-" + "0" + (monthOfYear + 1) + "-" + year1;
                        } else {
                            mSelectedToDate = dayOfMonth + "-" + "0" + (monthOfYear + 1) + "-" + year1;
                        }
                    } else {
                        mSelectedToDate = (monthOfYear + 1) + "-" + dayOfMonth + "-" + year1;
                    }
                    etEventDate.setText(mSelectedToDate);
                }, year, month, day);

                min_date_c.set(Calendar.YEAR, year - 200);
                datePickerDialog.setMinDate(min_date_c);
                // Setting Max Date to next 2 years
                max_date_c.set(Calendar.YEAR, year + 2000);
                datePickerDialog.setMaxDate(max_date_c);
                datePickerDialog.setThemeDark(false);
                datePickerDialog.showYearPickerFirst(false);
                datePickerDialog.setTitle("Date Picker");
                datePickerDialog.show(getActivity().getSupportFragmentManager(), "DatePickerDialog");
                break;
            case R.id.et_event_time:
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                String timeSet = "";
                                if (hourOfDay > 12) {
                                    hourOfDay -= 12;
                                    timeSet = "PM";
                                } else if (hourOfDay == 0) {
                                    hourOfDay += 12;
                                    timeSet = "AM";
                                } else if (hourOfDay == 12) {
                                    timeSet = "PM";
                                } else {
                                    timeSet = "AM";
                                }

                                String min = "";
                                if (minute < 10)
                                    min = "0" + minute;
                                else
                                    min = String.valueOf(minute);

                                // Append in a StringBuilder
                                aTime = new StringBuilder().append(hourOfDay).append(':')
                                        .append(min).append(" ").append(timeSet).toString();

                                etEventTime.setText(aTime);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
                break;
        }
    }

    public void sendBackResult() {
        if (!etDialogTaskname.getText().toString().isEmpty() && !etDialogLocation.getText().toString().isEmpty() && mSelectedToDate != null && aTime != null) {
            CallBackEventPopUP callBackEventPopUP = (CallBackEventPopUP) getTargetFragment();
            callBackEventPopUP.popUpResult(etDialogTaskname.getText().toString(), etDialogLocation.getText().toString(), mSelectedToDate.toString(), aTime);
            dismiss();
        } else {
            Toast.makeText(getContext(), "Please Fill All Field", Toast.LENGTH_SHORT).show();
        }

    }

}