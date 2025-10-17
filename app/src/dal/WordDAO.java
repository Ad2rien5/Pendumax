package dal;

import bo.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {

    private String url = "app/data/words.txt";

    private List<Word> selectAll() {
        List<Word> words = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            FileInputStream fichier = new FileInputStream(url);
            ois = new ObjectInputStream(fichier);
            Word word = (Word) ois.readObject();
            words.add(word);
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return words;
    }

    private void addWord(Word word) {
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fichier = new FileOutputStream(url);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(word);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void delWord(Word word) {
        List<Word> words = selectAll();
        words.remove(word);


    }
}