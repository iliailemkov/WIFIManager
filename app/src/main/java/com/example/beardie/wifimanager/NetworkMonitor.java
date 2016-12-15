package com.example.beardie.wifimanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NetworkMonitor extends BroadcastReceiver {
    private static final String LOG_TAG = "myNetworkMonitor" ;
    public List<ScanResult> scanResultList;

    public NetworkMonitor() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        scanResultList = wifiManager.getScanResults();
        for (ScanResult scanResult : scanResultList) {
            Log.d(LOG_TAG,scanResult.toString());
        }
        //context.unregisterReceiver(this);

        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<String> getScanResult(){
        ArrayList<String> stringList = new ArrayList<String>();
        for(int i = 0; i < scanResultList.size(); i++){
            stringList.add("SSID: " + scanResultList.get(i).SSID);
        }
        return stringList;
    }
}
