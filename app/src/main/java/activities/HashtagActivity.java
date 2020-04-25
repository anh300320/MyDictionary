package activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mydictionary.ListTags;
import com.example.mydictionary.R;

import java.util.List;

import adapters.SearchListAdapter;
import interfaces.OnItemClickListener;
import objects.Hashtag;
import objects.Word;

public class HashtagActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchListAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Word> listWords;
    Hashtag hashtag;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtag);

        toolbar = findViewById(R.id.activity_hashtag_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        hashtag = (Hashtag) getIntent().getSerializableExtra("hashtag");
        listWords = hashtag.getListWord();

        toolbar.setTitle(hashtag.getTag());

        recyclerView = findViewById(R.id.activity_hashtag_listword);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SearchListAdapter(listWords);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getBaseContext(), WordDetailActivity.class);
                Word word = listWords.get(position);
                intent.putExtra("word", word);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hashtag_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ListTags.delete(hashtag.getTag());
        ListTags.saveToFile(getBaseContext());
        return true;
    }
}
