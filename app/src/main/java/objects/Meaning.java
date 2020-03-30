package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meaning implements Serializable {
    String type;
    List<String> meaning = new ArrayList<>();

    public Meaning(){}

    public Meaning(String type) {
        this.type = type;
    }

    public Meaning(String type, List<String> meaning) {
        this.type = type;
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(List<String> meaning) {
        this.meaning = meaning;
    }

    public void addMeaning(String meaning){
        this.meaning.add(meaning);
    }

    public void show(){
        System.out.println(type+ "\n");
        int size = meaning.size();
        for(int i = 0; i< size; i++)
            System.out.println(meaning.get(i) + "\n");
    }

    public int size(){
        return meaning.size();
    }
}
