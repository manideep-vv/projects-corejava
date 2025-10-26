package jsonDemo;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {
    public void readUsingJsonSimpleGson(){

        String data="{\"accountNumber\": 100, \"name\": \"Devi\", \"balance\": 24.98}";
        JSONObject obj = (JSONObject)JSONValue.parse(data);

        System.out.println(obj.get("name"));
        System.out.println(System.getProperty("user.home"));

    }
    public void readUsingJsonSimpleGsonFromFile() throws FileNotFoundException {
        File file = Paths.get(System.getProperty("user.home"), "OneDrive","Documents", "mani.JSON").toFile();
        JSONObject obj = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(obj.get("address.zipCode"));
    }

    public static void main(String[] args) throws FileNotFoundException {
//        new JsonReader().readUsingJsonSimpleGson();;
        new JsonReader().readUsingJsonSimpleGsonFromFile();;
    }

}
