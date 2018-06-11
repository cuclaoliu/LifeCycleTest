package edu.cuc.stephen.lifecycletest;

import android.os.Bundle;
import android.app.Activity;

public class SecondActivity extends TracerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.textColor = "#EEEE00";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

}
