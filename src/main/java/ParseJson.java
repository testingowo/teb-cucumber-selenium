import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJson {

    public static String getUrlByDescriptor(String descriptor) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/env.json"));
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject.get(descriptor));
        return jsonObject.get(descriptor).toString();
    }
}
