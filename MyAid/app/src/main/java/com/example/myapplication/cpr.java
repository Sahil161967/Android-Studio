package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class cpr extends MainActivity{

    Intent i;
    View v;
    Button button,emergency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpr);

        button=(Button)findViewById(R.id.back);
        emergency=(Button)findViewById(R.id.emergency);


        button.setOnClickListener((View)-> {
            i=new Intent(this,MainActivity.class);
            startActivity(i);

        });



        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:102"));
                    startActivity(i);


            }
        });


    }

    }
