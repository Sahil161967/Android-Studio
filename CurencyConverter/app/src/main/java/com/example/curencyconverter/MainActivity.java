package com.example.curencyconverter;



import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import static com.example.curencyconverter.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    private EditText inrInput;
    private TextView Output;
    private Button usd;
    private Button eur;
    private Button yen;
    private Button cny;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        inrInput = findViewById(R.id.editText1);
        Output = findViewById(R.id.textView3);
        usd = findViewById(R.id.button1);
        eur = findViewById(R.id.button2);
        yen = findViewById(R.id.button3);
        cny = findViewById(R.id.button4);



        { usd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inrAmount = Double.parseDouble(inrInput.getText().toString());
                double usdAmount = inrAmount * 82.03;
                Output.setText(String.format("%.2f", usdAmount));
            }
        });

        eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inrAmount = Double.parseDouble(inrInput.getText().toString());
                double eurAmount = inrAmount * 89.80;
                Output.setText(String.format("%.2f", eurAmount));
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inrAmount = Double.parseDouble(inrInput.getText().toString());
                double yenAmount = inrAmount * 0.61;
                Output.setText(String.format("%.2f", yenAmount));
            }
        });

        cny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inrAmount = Double.parseDouble(inrInput.getText().toString());
                double cnyAmount = inrAmount * 11.94;
                Output.setText(String.format("%.2f", cnyAmount));
            }
        });
    }
}}