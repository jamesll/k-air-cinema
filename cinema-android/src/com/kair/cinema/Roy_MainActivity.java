package com.kair.cinema;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.kair.cinema.seatbooking.SeatBooking;

public class Roy_MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roy__main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("2012/10/1");
        adapter.add("2012/10/2");
        adapter.add("2012/10/3");
        adapter.add("2012/10/4");
        adapter.add("2012/10/5");
        adapter.add("2012/10/6");

        Spinner spinnerDate = (Spinner) findViewById(R.id.sprinner_date);
        spinnerDate.setAdapter(adapter);
        spinnerDate.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent,
                    final View view, final int position, final long id) {
                // Spinner spinner = (Spinner) parent;
                // Log.v("Test", "id = " + id + "("
                // + spinner.getSelectedItem().toString() + ")");
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });

        Spinner spinnerTime = (Spinner) findViewById(R.id.sprinner_time);
        ArrayAdapter<String> adapterTime = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item);
        adapterTime
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTime.add("08:00");
        adapterTime.add("12:00");
        adapterTime.add("16:00");
        adapterTime.add("17:00");
        adapterTime.add("20:00");
        adapterTime.add("22:00");
        spinnerTime.setAdapter(adapterTime);
        spinnerTime.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent,
                    final View view, final int position, final long id) {
                // Spinner spinner = (Spinner) parent;
                // Log.v("Test", "id = " + id + "("
                // + spinner.getSelectedItem().toString() + ")");
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });

        Button button = (Button) findViewById(R.id.book);
        button.setOnClickListener(new BookButtonOnClickListener(
                Roy_MainActivity.this));
    }

}

class BookButtonOnClickListener implements OnClickListener {
    private Context context;

    public BookButtonOnClickListener(final Context context) {
        this.context = context;
    }

    @Override
    public void onClick(final View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(context, SeatBooking.class);
        context.startActivity(intent);
    }

}
