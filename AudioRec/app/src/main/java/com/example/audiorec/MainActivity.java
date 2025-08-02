package com.example.audiorec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int RECORD_AUDIO=0;
    private MediaRecorder mediaRecorder;
    private String output=null;
    private ImageView record;
    private ImageView stop;

    private boolean permissionToRecordAccepted=false;
    private boolean permissionToWriteAccepted=false;
    private final String [] permissions = {"android.permission.RECORD_AUDIO","android.permission.WRITE_EXTERNAL_STORAGE"};

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int requestCode=200;
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
        {
            requestPermissions(permissions,requestCode);
        }

        record=(ImageView)findViewById(R.id.record);
        stop=(ImageView)findViewById(R.id.stop);
        ImageView play = (ImageView) findViewById(R.id.play);

        record.setOnClickListener(this);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);

        stop.setEnabled(false);
        play.setEnabled(false);

        output= Environment.getExternalStorageDirectory().getAbsolutePath()+"/myrecording.3gp";

        mediaRecorder= new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(output);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.record:
                record(v);
                break;
            case R.id.stop:
                mediaRecorder.stop();
                break;
            case R.id.play:
                try {
                    play(v);
                }
                catch (IOException e){
                    Log.i("IOException","Error in Play");
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 200) {
            permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            permissionToWriteAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
        }
        if (!permissionToRecordAccepted) MainActivity.super.finish();
        if (!permissionToWriteAccepted) MainActivity.super.finish();
    }
    public void record(View view)
    {
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        record.setEnabled(false);
        stop.setEnabled(true);

        Toast.makeText(getApplicationContext(),"RECORDING STARTED BOSS ;)",Toast.LENGTH_SHORT).show();
    }
    public void play(View view) throws IllegalArgumentException,SecurityException,IllegalStateException,IOException
    {
        MediaPlayer m=new MediaPlayer();
        m.setDataSource(output);
        m.prepare();
        m.start();

        Toast.makeText(getApplicationContext(),"PLAYING AUDIO <3",Toast.LENGTH_SHORT).show();
    }
}