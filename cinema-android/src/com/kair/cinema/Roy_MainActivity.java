package com.kair.cinema;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Roy_MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roy_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_roy_main, menu);
        return true;
    }
}
