package com.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "BluetoothBroadcastre";

    public BluetoothBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            int currentstate = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
            int previousstate = intent.getIntExtra(BluetoothAdapter.EXTRA_PREVIOUS_STATE, -1);
            Log.d(LOG_TAG, "onReceive State Changed: " + currentstate + " " + previousstate);
        } else if (action.equals(BluetoothDevice.ACTION_FOUND)) {
            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            BluetoothActivity.addToArrayAdaptor(device);
        }
    }
}
