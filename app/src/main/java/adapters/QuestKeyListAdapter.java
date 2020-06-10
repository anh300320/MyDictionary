package adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.LeinerSystem;
import com.example.mydictionary.ListWords;
import com.example.mydictionary.QuestList;
import com.example.mydictionary.R;
import com.example.mydictionary.SearchingWords;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import activities.AddWordActivity;
import activities.DoQuestActivity;
import interfaces.OnItemClickListener;
import objects.Meaning;
import objects.Word;

public class QuestKeyListAdapter extends RecyclerView.Adapter<QuestKeyListAdapter.MyViewHolder>{

    public QuestList list = new QuestList();

    private Random random = new Random();

    public boolean isAnnounce_semaphore() {
        return announce_semaphore;
    }

    private boolean announce_semaphore;

    public QuestKeyListAdapter(List<String> quest){
        Collections.shuffle(quest);
        for (String key : quest){
            try {
                Word word = ListWords.getAll().get(SearchingWords.find(key));
                list.add(word);
            } catch (Exception e){
                Word newWord = new Word(key);
                list.add(newWord);
            }
        }
    }

    @NonNull
    @Override
    public QuestKeyListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.quest_key_list_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestKeyListAdapter.MyViewHolder holder, final int position) {
        Word word = list.getWord(position);
        holder.key_tv.setText(word.getRawKey());
        holder.type_tv.setText(word.getMeanings().get(random.nextInt(word.getMeaningsSize())).getType());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView key_tv;
        private TextView type_tv;
        private EditText meaning_input;
        View view;

        public MyViewHolder(View itemView){
            super(itemView);
            initItemView();
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        private void initItemView(){
            key_tv = itemView.findViewById(R.id.quest_key_list_view_key);
            type_tv = itemView.findViewById(R.id.quest_key_list_view_type);
            meaning_input = itemView.findViewById(R.id.quest_key_list_view_edit_meaning);
        }

        @Override
        public void onClick(View v) {
            Log.d("hehe", "onClick: ");
        }

        @Override
        public boolean onLongClick(View v){
            int position = getAdapterPosition();
            list.remove(position);
            notifyItemRemoved(position);
            word_score(position);
            print_announce();
            return true;
        }

        private void word_score(int position){
            if (isCorrect(position)){

            }
        }
        private boolean isCorrect(int position){
            Word word = list.getWord(position);
            return true;
        }
        private void print_announce(){
            if (list.isEmpty()) announce_semaphore = true;
            else announce_semaphore = false;
        }
    }


}
