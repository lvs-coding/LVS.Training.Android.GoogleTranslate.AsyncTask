package com.example.googletranslateasync.models;

/**
 * Created by laurent on 1/16/17.
 */

public class TranslationTaskParams {
    private String mApiKey;
    private String mTextToTranslate;

    public TranslationTaskParams(String apiKey, String textToTranslate) {
        mApiKey = apiKey;
        mTextToTranslate = textToTranslate;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public String getTextToTranslate() {
        return mTextToTranslate;
    }

}