package bo;

public class Word {
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
}