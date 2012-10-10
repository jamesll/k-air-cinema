package com.kair.cinema;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

public class Roy_MainActivity extends Activity {

    private TextView showDate = null;
    private Button pickDate = null;
    private TextView showTime = null;
    public Button pickTime = null;
    public TextView tv1 = null;
    public TextView tv5 = null;
    public ImageView iv5 = null;

    private static final int SHOW_DATAPICK = 0;
    private static final int DATE_DIALOG_ID = 1;
    private static final int SHOW_TIMEPICK = 2;
    private static final int TIME_DIALOG_ID = 3;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roy__main);

        ImageView iv1 = (ImageView) findViewById(R.id.ImageView01);
        tv1 = (TextView) findViewById(R.id.showtime);
        tv5 = (TextView) findViewById(R.id.TextView05);
        iv5 = (ImageView) findViewById(R.id.ImageView05);

        initializeViews();

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Test Movie picture showup
        final Context context = Roy_MainActivity.this.getApplicationContext();

        OnClickListener listener10 = new OnClickListener() {
            public void onClick(final View v) {
                new AlertDialog.Builder(context).setTitle("test")
                        .setMessage("test").setPositiveButton("ȷ��", null)
                        .show();

            }
        };
        iv5.setOnClickListener(listener10);

        setDateTime();
        setTimeOfDay();

        // System.out.println(tv1.getText());

    }

    /**
     * ��ʼ���ؼ���UI��ͼ
     */
    private void initializeViews() {
        showDate = (TextView) findViewById(R.id.showdate);
        pickDate = (Button) findViewById(R.id.pickdate);
        showTime = (TextView) findViewById(R.id.showtime);
        pickTime = (Button) findViewById(R.id.picktime);

        pickDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                Message msg = new Message();
                if (pickDate.equals(v)) {
                    msg.what = Roy_MainActivity.SHOW_DATAPICK;
                }
                Roy_MainActivity.this.dateandtimeHandler.sendMessage(msg);
            }
        });

        pickTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                Message msg = new Message();
                if (pickTime.equals(v)) {
                    msg.what = Roy_MainActivity.SHOW_TIMEPICK;
                }

                iv5.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.VISIBLE);

                System.out.println(tv1.getText());
                if (tv1.getText().equals("12:58")) {
                    // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
                    iv5.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                }

                Roy_MainActivity.this.dateandtimeHandler.sendMessage(msg);
            }
        });
    }

    /**
     * ��������
     */
    private void setDateTime() {
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        updateDateDisplay();
    }

    /**
     * ����������ʾ
     */
    private void updateDateDisplay() {
        showDate.setText(new StringBuilder().append(mYear).append("-")
                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                .append("-").append((mDay < 10) ? "0" + mDay : mDay));
    }

    /**
     * ���ڿؼ����¼�
     */
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(final DatePicker view, final int year,
                final int monthOfYear, final int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            updateDateDisplay();
        }
    };

    /**
     * ����ʱ��
     */
    private void setTimeOfDay() {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        updateTimeDisplay();
    }

    /**
     * ����ʱ����ʾ
     */
    private void updateTimeDisplay() {
        showTime.setText(new StringBuilder().append(mHour).append(":")
                .append((mMinute < 10) ? "0" + mMinute : mMinute));
    }

    /**
     * ʱ��ؼ��¼�
     */
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(final TimePicker view, final int hourOfDay,
                final int minute) {
            mHour = hourOfDay;
            mMinute = minute;

            updateTimeDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(final int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                    mDay);
        case TIME_DIALOG_ID:
            return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute,
                    true);
        }

        return null;
    }

    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog) {
        switch (id) {
        case DATE_DIALOG_ID:
            ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
            break;
        case TIME_DIALOG_ID:
            ((TimePickerDialog) dialog).updateTime(mHour, mMinute);
            break;
        }
    }

    /**
     * �������ں�ʱ��ؼ���Handler
     */
    Handler dateandtimeHandler = new Handler() {

        @Override
        public void handleMessage(final Message msg) {
            switch (msg.what) {
            case Roy_MainActivity.SHOW_DATAPICK:
                showDialog(DATE_DIALOG_ID);
                break;
            case Roy_MainActivity.SHOW_TIMEPICK:
                showDialog(TIME_DIALOG_ID);
                break;
            }
        }

    };

}
