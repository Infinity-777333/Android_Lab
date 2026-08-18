package com.example.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("Activity Created");

        Button onCreateBtn=findViewById(R.id.button1);
        Button onStartBtn=findViewById(R.id.button2);
        Button onPauseBtn=findViewById(R.id.button3);
        Button onStopBtn=findViewById(R.id.button4);
        Button onRestartBtn=findViewById(R.id.button5);
        Button onDestroyBtn=findViewById(R.id.button6);

        onCreateBtn.setOnClickListener(v-> showToast("ONCREATE() CLICKED"));
        onStartBtn.setOnClickListener(v-> showToast("ONSTART() CLICKED"));
        onPauseBtn.setOnClickListener(v-> showToast("ONPAUSE() CLICKED"));
        onStopBtn.setOnClickListener(v-> showToast("ONSTOP() CLICKED"));
        onRestartBtn.setOnClickListener(v-> showToast("ONRESTART() CLICKED"));
        onDestroyBtn.setOnClickListener(v-> showToast("ONDESTROY() CLICKED"));

    }
    @Override
    protected void onStart() {
        super.onStart();
        showToast("Activity Started");
    }
    @Override
    protected void onResume() {
        super.onResume();
        showToast("Activity Resumed");
    }
    @Override
    protected void onPause() {
        super.onPause();
        showToast("Activity Paused");
    }
    @Override
    protected void onStop() {
        super.onStop();
        showToast("Activity Stopped");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("Activity Restarted");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("Activity Destroyed");
    }
    void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
