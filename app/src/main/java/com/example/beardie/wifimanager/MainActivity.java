package com.example.beardie.wifimanager;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        final NetworkMonitor networkMonitor = new NetworkMonitor();
        final ListView listView = (ListView) findViewById(R.id.list_new);
        final ArrayAdapter<String> adapter;


        networkMonitor.onReceive(this, intent);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, networkMonitor.getScanResult());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Details");
                TextView textView = new TextView(MainActivity.this);
                textView.setText("SSID: " + networkMonitor.scanResultList.get(i).SSID +
                        "\nBSID: " + networkMonitor.scanResultList.get(i).BSSID +
                        "\nEncryption: " + networkMonitor.scanResultList.get(i).capabilities +
                        "\nSignal: " + networkMonitor.scanResultList.get(i).level +
                        "\nFrequency: " + networkMonitor.scanResultList.get(i).frequency);
                textView.setTextSize(17);
                alertDialog.setView(textView);
                alertDialog.show();
            }
        });

        Button button = (Button) findViewById(R.id.button_update);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                adapter.addAll(networkMonitor.getScanResult());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
