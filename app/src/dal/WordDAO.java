package dal;

import bo.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {

    private final String url = "app/data/words.ser";

    public WordDAO() {}

    public List<Word> getWords() {
        File file = new File(url);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Word>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Word> getBasicsWords() {
        List<Word> words = getWords();
        List<Word> basics = new ArrayList<>();
        for (Word word : words) {
            if (!word.isUti()) {
                basics.add(word);
            }
        }
        return basics;
    }

    public void addWord(Word word) {
        List<Word> words = getWords();
        words.add(word);
        saveWords(words);
    }

    public void delWord(Word word) {
        List<Word> words = getWords();
        words.remove(word);
        saveWords(words);
    }

    private void saveWords(List<Word> words) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(url))) {
            oos.writeObject(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
