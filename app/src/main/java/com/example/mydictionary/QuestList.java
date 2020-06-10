package com.example.mydictionary;

import java.util.ArrayList;
import java.util.List;

import objects.Word;
import objects.WordList;

public class QuestList extends WordList {
    private List<Word> listWord = new ArrayList<>();
    private int type_number;

    public int getType_number() {
        return type_number;
    }

}
