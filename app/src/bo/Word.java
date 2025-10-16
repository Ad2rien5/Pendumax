package bo;

public class word {
    private String word;
    private boolean uti;

    public word(String word, boolean uti) {
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