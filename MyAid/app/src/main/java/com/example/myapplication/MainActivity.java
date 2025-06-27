package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ImageButton cprButton = findViewById(R.id.cprButton);
        cprButton.setOnClickListener(View->
        {
            i=new Intent(this,cpr.class);
            startActivity(i);
        });

        ImageButton skinButton = findViewById(R.id.burnButton);
        skinButton.setOnClickListener(View->
        {
            i=new Intent(this,skinburn.class);
            startActivity(i);
        });

        ImageButton boneButton = findViewById(R.id.brokenButton);
        boneButton.setOnClickListener(View->
        {
            i=new Intent(this,bone.class);
            startActivity(i);
        });

        ImageButton snakeButton = findViewById(R.id.biteButton);
        snakeButton.setOnClickListener(View->
        {
            i=new Intent(this,snake.class);
            startActivity(i);
        });


        ImageButton chokeButton = findViewById(R.id.choking);
        chokeButton.setOnClickListener(View->
        {
            i=new Intent(this,choking.class);
            startActivity(i);
        });


        ImageButton shockButton = findViewById(R.id.shock);
        shockButton.setOnClickListener(View->
        {
            i=new Intent(this,shock.class);
            startActivity(i);
        });

        ImageButton poisonButton = findViewById(R.id.poison);
        poisonButton.setOnClickListener(View->
        {
            i=new Intent(this,poison.class);
            startActivity(i);
        });
    }
}