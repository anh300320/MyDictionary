package activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.LeinerSystem;
import com.example.mydictionary.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import adapters.QuestKeyListAdapter;
import adapters.SearchListAdapter;
import interfaces.OnItemClickListener;

public class DoQuestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    QuestKeyListAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView noquest_tv;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_quest);
        makeQuest();
        init();
        showText();
        onClick();
    }
    private void makeQuest(){
        if (LeinerSystem.isNewDay()) {
            LeinerSystem.COMPLETING = false;
            LeinerSystem.catchNewDay();
            LeinerSystem.makeDailyQuest();
        }
    }


    private void init(){
        noquest_tv = findViewById(R.id.activity_do_quest_noquest_tv);
        recyclerView = findViewById(R.id.activity_do_quest_listkey);
        layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        mAdapter = new QuestKeyListAdapter(LeinerSystem.getQuest());
        recyclerView.setAdapter(mAdapter);
    }
    private void onClick(){
    }

    private void showText(){
        if (mAdapter.getItemCount() == 0) {
            noquest_tv.setVisibility(View.VISIBLE);
        }
        else if (noquest_tv.getVisibility() == View.VISIBLE) noquest_tv.setVisibility(View.GONE);
    }

    private void onItemClick(){

    }
}
