package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class shock extends MainActivity {

    Intent i;
    Button button,emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shock);

        button=(Button)findViewById(R.id.back);
        emergency=findViewById(R.id.emergency);

        button.setOnClickListener((View)-> {
            i=new Intent(this,MainActivity.class);
            startActivity(i);

        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:102"));
                startActivity(i);


            }
        });
    }
}
