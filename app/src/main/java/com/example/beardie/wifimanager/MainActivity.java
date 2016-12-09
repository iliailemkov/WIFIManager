package com.example.beardie.wifimanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent();
        NetworkMonitor networkMonitor = new NetworkMonitor();
        networkMonitor.onReceive(this, intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
