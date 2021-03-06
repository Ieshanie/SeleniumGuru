package Utility;

import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    static JSONParser parser = new JSONParser();
    public static String ReadJSONFile (String nameParameter, String filePath) throws FileNotFoundException, IOException, ParseException
    {
        Object obj = parser.parse(new FileReader(filePath));

        JSONObject jsonObject = (JSONObject) obj;
        String value = (String) jsonObject.get(nameParameter);
        return value;
    }
}
