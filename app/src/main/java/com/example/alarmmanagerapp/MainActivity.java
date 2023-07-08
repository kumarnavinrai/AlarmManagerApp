package com.example.alarmmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edtTime);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(((EditText)(findViewById(R.id.edtTime))).getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000);

                Intent iBroadCast = new Intent(MainActivity.this, MyReciver.class);
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ_CODE, iBroadCast, PendingIntent.FLAG_IMMUTABLE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pi);
            }
        });




    }
}