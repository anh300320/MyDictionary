package com.example.mydictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.SearchSuggestionsAdapter;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fragments.BookmarkFragment;
import fragments.SearchFragment;
import fragments.UserFragment;
import fragments.VocabularyFragment;
import objects.Meaning;
import objects.Word;
import objects.WordSuggestion;

public class MainActivity extends AppCompatActivity {

    AssetManager am;
    BufferedReader reader;
    InputStream in;

    Toolbar toolbar;
    FloatingSearchView searchView;
    BottomNavigationView bottomNavigationView;
    SearchFragment searchFragment = new SearchFragment();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = getBaseContext().getAssets();

        try {
            reader = new BufferedReader(new InputStreamReader(am.open("databases/dictionary_data.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ListWords.setListWords(readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }



        findViewById();

        searchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {

            @Override
            public void onSearchAction(String currentQuery) {
                searchWord(SearchingWords.search(currentQuery));
            }

            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                searchView.setSearchText(searchSuggestion.getBody());
                onSearchAction(searchSuggestion.getBody());
                searchView.clearSearchFocus();
            }
        });

        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                searchView.swapSuggestions(SearchingWords.getSuggestion(newQuery));
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){
                    case R.id.navigation_dict:
                        selectedFragment = searchFragment;
                        break;
                    case R.id.navigation_bookmark:
                        selectedFragment = new BookmarkFragment();
                        break;
                    case R.id.navigation_vocab:
                        selectedFragment = new VocabularyFragment();
                        break;
                    case R.id.navigation_user:
                        selectedFragment = new UserFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.navigation_dict);

    }

    public void searchWord(List<Word> listWord){
        bottomNavigationView.setSelectedItemId(R.id.navigation_dict);
        searchFragment.search(listWord);
    }

    public void findViewById(){
        //toolbar = findViewById(R.id.main_toolbar);
        searchView = findViewById(R.id.main_searchview);
        bottomNavigationView = findViewById(R.id.navigation_view);
    }

    List<Word> readFile() throws IOException {
        List<Word> list = new ArrayList<>();
        Word tmp = new Word();
        while((tmp = readWord()) != null){
            Word newWord = tmp;
            list.add(newWord);
        }

        return list;
    }

    Word readWord() throws IOException {
        Word word = new Word();

        String line = reader.readLine();
        if(line == null) return null;
        else {
            line = line.replace("@", "");
            word.setKey(line);
            Meaning tmp = null;
            while((line = readLine()) != null)
                if(line.charAt(0) == '*') {
                    if (tmp != null) {
                        word.addMeaning(new Meaning(tmp.getType(), tmp.getMeaning()));
                        tmp = null;
                    }
                    line = line.replace("*", "");
                    tmp = new Meaning(line);
                }   else {
                    if (tmp != null) tmp.addMeaning(line);
                }
            if (tmp != null) word.addMeaning(tmp);
        }

        return  word;
    }

    String readLine() throws IOException {
        String line1 = reader.readLine();
        if((line1 != null) && (!line1.equals(""))) return line1;
        else return null;
    }

}
