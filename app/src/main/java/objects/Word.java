package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Word implements Serializable {
    String key;
    List<Meaning> meanings = new ArrayList<>();

    public Word(){}

    public Word(String key, List<Meaning> meanings) {
        this.key = key;
        this.meanings = meanings;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public void addMeaning(Meaning meaning){
        meanings.add(meaning);
    }

    public void show(){
        System.out.println(key + "\n");
        int size = meanings.size();
        for(int i = 0; i < size; i++)
            meanings.get(i).show();
    }

    public String showMeaning(){
        String result = "";
        int size = meanings.size();
        for(int i = 0; i<size; i++)
            if(i != size-1)
            result = result + meanings.get(i).getType() + ", ";
            else result = result + meanings.get(i).getType();
            return result;
    }

    public String showFullMeanings(){
        String result = "";
        int meaningSize = meanings.size();
        for(int i = 0 ; i < meaningSize; i++){
            result = result + meanings.get(i).getType()+ "\n";
            int size = meanings.get(i).size();
            for(int j = 0; j < size; j++)
                result = result + meanings.get(i).getMeaning().get(j) + "\n";
        }

        return result;
    }
}
