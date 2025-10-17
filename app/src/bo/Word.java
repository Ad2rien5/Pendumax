package bo;

import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable {
    private final String word;
    private final boolean uti;

    public Word(String word, boolean uti) {
        this.word = word;
        this.uti = uti;
    }

    public String getWord() {
        return word;
    }

    public boolean isUti() {
        return uti;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return uti == word1.uti && Objects.equals(word, word1.word);
    }
}