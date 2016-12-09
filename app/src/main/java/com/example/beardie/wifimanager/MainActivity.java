package com.example.beardie.wifimanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        NetworkMonitor networkMonitor = new NetworkMonitor();
        ListView listView;
        listView = (ListView) findViewById(R.id.list_new);
        ArrayAdapter<String> adapter;

        networkMonitor.onReceive(this, intent);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, networkMonitor.getScanResult());
        listView.setAdapter(adapter);
    }
}
