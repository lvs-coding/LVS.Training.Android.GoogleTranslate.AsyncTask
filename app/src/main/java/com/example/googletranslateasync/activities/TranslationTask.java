package com.example.googletranslateasync.activities;

import android.os.AsyncTask;

import com.example.googletranslateasync.interfaces.TranslationRequest;
import com.example.googletranslateasync.models.TranslationTaskParams;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

/**
 * Created by laurent on 1/16/17.
 */

public class TranslationTask extends AsyncTask<TranslationTaskParams, Integer, String> {
    public TranslationRequest response = null;

    @Override
    protected String doInBackground(TranslationTaskParams... translationTaskParams) {
        String translatedText = "";
        String apiKey = translationTaskParams[0].getApiKey();
        TranslateOptions options = TranslateOptions.newBuilder()
                .setApiKey(apiKey)
                .build();
        Translate translate = options.getService();
        final Translation translation =
                translate.translate(translationTaskParams[0].getTextToTranslate(),
                        Translate.TranslateOption.targetLanguage("fr"));
        translatedText = translation.getTranslatedText();
        return translatedText;
    }

    protected void onPostExecute(String result) {
        response.requestDone(result);
    }
}

