package com.example.bluetoothfunc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button enable,disable,search;
    AlertDialog AlertDialog;
    public BluetoothAdapter ba;
    public Set<BluetoothDevice>pairedDevices;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enable=(Button)findViewById(R.id.enable);
        disable=(Button)findViewById(R.id.disabled);
        search=(Button)findViewById(R.id.search);
        ba=BluetoothAdapter.getDefaultAdapter();

    }

    public void enable(View view)
    {
        if (!ba.isEnabled())
        {
            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i,0);

            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Bluetooth Enabled Sucessfully");
        }
    }
    public void disabled(View view)
    {
         ba.disable();
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Bluetooth Disabled Sucessfully");
    }
    public void search(View view)
    {
        Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        i.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,120);
        startActivityForResult(i,0);
    }

}