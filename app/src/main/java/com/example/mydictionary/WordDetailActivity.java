package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import objects.Word;

public class WordDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvKey;
    TextView tvMeanings;
    Word word;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);

        findViewById();

        intent = getIntent();
        word =(Word) intent.getSerializableExtra("word");

        tvKey.setText(word.getKey());
        tvMeanings.setText(word.showMeaning());
        toolbar.setTitle(word.getKey());
    }

    private void findViewById(){
        tvKey = findViewById(R.id.detail_key);
        tvMeanings = findViewById(R.id.detail_meanings);
        toolbar = findViewById(R.id.detail_toolbar);
    }
}
