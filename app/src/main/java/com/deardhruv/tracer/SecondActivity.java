package com.deardhruv.tracer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by deardhruv on 19-05-2017.
 */

public class SecondActivity extends TracerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> closeActivity());

        ((TextView) findViewById(R.id.txt_title)).setText(getClass().getSimpleName());

    }

    private void closeActivity() {
        setResult(RESULT_OK);
        finish();
    }
}
