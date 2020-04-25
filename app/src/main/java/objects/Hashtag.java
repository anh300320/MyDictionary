package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hashtag implements Serializable {
    String tag;
    List<Word> listWord = new ArrayList<>();

    public String getTag(){
        return tag;
    }

    public Word getWord(int position){
        return listWord.get(position);
    }

    public Hashtag(String tag) {
        this.tag = tag;
    }

    public void add(Word word){
        listWord.add(word);
    }

    public void add(String key){
        listWord.add(new Word(key));
    }

    public Word getLast(){
        int size = listWord.size();
        if(size > 0) return listWord.get(size -1);
            else return null;
    }

    public void remove(int position){
        listWord.remove(position);
    }

    public void remove(Word word){
        listWord.remove(word);
    }

    public String show(){
        String result = "#" + tag + "\n";
        int size = listWord.size();
        for(int i = 0; i<size; i++){
            Word word = listWord.get(i);
            result = result + "@" + word.key + "\n";
            result = result + word.showFullMeanings();
        }
        //result = result + "\n";
        return result;
    }

    public List<Word> getListWord() {
        return listWord;
    }
}
