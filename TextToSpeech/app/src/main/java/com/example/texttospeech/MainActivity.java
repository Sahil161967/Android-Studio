package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button speakBtn;
    EditText speakText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speakText=(EditText)findViewById(R.id.edit);
        speakBtn=(Button)findViewById(R.id.btn);
        textToSpeech=new TextToSpeech(this,this);

        speakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texttoSpeak();
            }
        });
    }
    public void onInit(int status)
    {
        if (status==TextToSpeech.SUCCESS)
        {
            int result=textToSpeech.setLanguage(Locale.US);
            if (result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("Error","This Lang is not supported");
            }
            else
            {
                Log.e("Error","Failed to onitialize");
            }
        }
    }

    public void onDestroy()
    {
        if (textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private void texttoSpeak()
    {
        String text=speakText.getText().toString();

        if ("".equals(text))
        {
            text="please Enter some text ti speak";
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }
    else
        {
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}