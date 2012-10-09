package com.kair.cinema;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.kair.cinema.adapter.MovieGridAdapter;
import com.kair.cinema.db.MovieDao;
import com.kair.cinema.seatbooking.SeatBooking;
import com.kair.cinema.vo.MovieGridItem;

public class MainActivity extends Activity {

    private GridView gridview;
    private MovieDao movieDao = new MovieDao();
    private MovieGridAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.gridview);
        List<MovieGridItem> list = movieDao.findMovieGridItem();
        adapter = new MovieGridAdapter(this);
        adapter.setList(list);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> arg0, final View arg1,
                    final int arg2, final long arg3) {
                // TODO Auto-generated method stub
                // Toast.makeText(MainActivity.this.getApplicationContext(),
                // "you choose " + arg2, 1000).show();
                Intent intent = new Intent(MainActivity.this, SeatBooking.class);
                startActivity(intent);
            }
        });
    }

}
