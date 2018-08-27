package com.deardhruv.tracer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends TracerActivity {

    public static final int REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setRotation(180);
        fab.setOnClickListener(view -> fabAction());

        ((TextView) findViewById(R.id.txt_title)).setText(getClass().getSimpleName());


        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        if (appLinkIntent != null) {
            String appLinkAction = appLinkIntent.getAction();
            if (appLinkAction != null) {
                Uri appLinkData = appLinkIntent.getData();
                if (appLinkData != null) {
                    ((TextView) findViewById(R.id.txt_title)).setText(appLinkData.toString().concat("\n").concat(getClass().getSimpleName()));
                }
            }
        }
    }

    private void fabAction() {
        startActivityForResult(new Intent(MainActivity.this, SecondActivity.class), REQUEST_CODE);
    }

}
