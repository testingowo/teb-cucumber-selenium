package parser;

import com.github.javafaker.Faker;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {

    public static String getUrlByDescriptor(String descriptor) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/env.json"));
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject.get(descriptor));
        return jsonObject.get(descriptor).toString();
    }

    public static String generateTestData(String dataName) {
        Faker faker = new Faker();

        switch(dataName){
            case "name":
                return faker.funnyName().name();
            case "comment":
                return faker.lorem().sentence();
            case "email":
                return faker.name().firstName() + "@gmail.com";
            case "website":
                return faker.witcher().character().replaceAll(" ", ".") + ".com";
            default:
                return "Wrong data name provided";
        }
    }
}
