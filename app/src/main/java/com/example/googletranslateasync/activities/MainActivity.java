package com.example.googletranslateasync.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.googletranslateasync.BuildConfig;
import com.example.googletranslateasync.R;
import com.example.googletranslateasync.interfaces.TranslationRequest;
import com.example.googletranslateasync.models.TranslationTaskParams;

public class MainActivity extends AppCompatActivity implements TranslationRequest {
    private static String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String GOOGLE_TRANSLATION_API_KEY = BuildConfig.GOOGLE_TRANSLATION_API_KEY;

    TextView tvTranslation;
    EditText etToTranslate;
    Button btnTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();


    }

    private void initListener() {
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translate(GOOGLE_TRANSLATION_API_KEY, etToTranslate.getText().toString());
            }
        });
    }

    private void init() {
        tvTranslation = (TextView)findViewById(R.id.tv_translation);
        etToTranslate = (EditText)findViewById(R.id.et_to_translate);
        btnTranslate = (Button)findViewById(R.id.btn_translate);
    }

    private void translate(String apiKey, String textToTranslate) {
        TranslationTask translationTask = new TranslationTask();
        translationTask.response = this;
        TranslationTaskParams params = new TranslationTaskParams(apiKey,textToTranslate);
        translationTask.execute(params);
    }

    @Override
    public void requestDone(String output) {
        tvTranslation.setText(output);
    }
}
