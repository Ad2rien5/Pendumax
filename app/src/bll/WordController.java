package bll;

import bo.Word;
import dal.WordDAO;

import java.util.List;
import java.util.Random;

public class WordController {

    private static WordController instance = null;
    private final WordDAO wordDAO;

    private WordController() {
        wordDAO = new WordDAO();
    }

    public static WordController getInstance() {
        if (instance == null) {
            instance = new WordController();
        }
        return instance;
    }

    public Word getWord(boolean uti) {
        List<Word> words;
        Random random = new Random();

        if (uti) {
            words = wordDAO.getWords();
        } else {
            words = wordDAO.getBasicsWords();
        }
        return words.get(random.nextInt(words.size()));
    }

    public boolean addWord(String mot) {
        if (mot.length() < 2 || mot.length() > 15) {
            return false;
        }
        Word word = new Word(mot, true);
        wordDAO.addWord(word);
        return true;
    }

    public void deleteWord(String mot) {
        Word word = new Word(mot, true);
        wordDAO.delWord(word);
    }
}
