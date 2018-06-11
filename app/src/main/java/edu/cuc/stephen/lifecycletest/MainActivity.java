package edu.cuc.stephen.lifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends TracerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        textColor = "#EEEEEE";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startSecondActivityButton = findViewById(R.id.start_snd_activity);
        startSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}
