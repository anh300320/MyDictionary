package activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.mydictionary.ListQuests;
import com.example.mydictionary.ListWords;
import com.example.mydictionary.R;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import adapters.QuestAdapter;

public class DoQuest2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    QuestAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    int numQuest;

    String filename = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_quest2);

        findViewById();

        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new QuestAdapter(ListQuests.getAll(), getBaseContext());
        numQuest = mAdapter.getItemCount();
        recyclerView.setAdapter(mAdapter);
    }

    private void findViewById(){
        recyclerView = findViewById(R.id.activity_do_quest2_listquest);
    }

    ///////////////////////////////////////////////
}
