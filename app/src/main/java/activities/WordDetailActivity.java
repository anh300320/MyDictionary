package com.example.mydictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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
        tvMeanings.setText(word.showFullMeanings());
        toolbar.setTitle(word.getKey());
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
    }

    private void findViewById(){
        tvKey = findViewById(R.id.detail_key);
        tvMeanings = findViewById(R.id.detail_meanings);
        toolbar = findViewById(R.id.detail_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.word_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getBaseContext(), WordMarkActivity.class);
        intent.putExtra("word", word);
        startActivity(intent);
        return true;
    }
}