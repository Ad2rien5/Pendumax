package dal;

import bo.Word;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WordDAO {

    private String url = "app/data/words.json";

    private List<Word> selectAll() {
        try {
            Object o = new JSONParser().parse(new FileReader(url));
            JSONArray array = (JSONArray) o;

            for (int i = 0; i < array.size(); i++) {
                Object obj = array.get(i);

            }

        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return;
    }
}