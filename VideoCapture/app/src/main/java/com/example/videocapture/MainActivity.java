package com.example.videocapture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    public static final int VIDEO_REQUEST=999;
    VideoView videoView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=(VideoView)findViewById(R.id.vv);
        button=(Button)findViewById(R.id.btn);
    }
    public void rec(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent,VIDEO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==VIDEO_REQUEST)
        {
            Uri uri=data.getData();
            videoView.setVideoURI(uri);

            MediaController mm=new MediaController(this);
            mm.setAnchorView(videoView);
            videoView.setMediaController(mm);
            videoView.requestFocus();
            videoView.start();
        }
    }
}