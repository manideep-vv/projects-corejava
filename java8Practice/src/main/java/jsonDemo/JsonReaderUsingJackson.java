package jsonDemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReaderUsingJackson {
    public void readUsingJackson() throws IOException {
        File file = Paths.get("src/main/resources/mani.JSON").toFile();
        ObjectMapper mapper=new ObjectMapper();

        //Reading as full tree
        JsonNode jsonNode = mapper.readTree(file);
        String text = jsonNode.path("address").path("zipCode").asText();
        System.out.println(text);

        //Read From String
        String car= "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        Car car1 = mapper.readValue(car, Car.class);
        System.out.println(car1);

        //Read from reader
        Reader reader=new StringReader(car);
        Car car2 = mapper.readValue(reader, Car.class);
        System.out.println(car2);

        //Read from file
        File file1 = Paths.get("src/main/resources/sampleChatGPT.JSON").toFile();
        RandomDataHolder randomDataHolder = mapper.readValue(file1, RandomDataHolder.class);
        System.out.println(randomDataHolder);

        //Reading from input stream
        FileInputStream fileInputStream = new FileInputStream(file1);
        RandomDataHolder r1 = mapper.readValue(fileInputStream, RandomDataHolder.class);
        System.out.println(r1);


    }


    public static void main(String[] args) throws IOException {
        new JsonReaderUsingJackson().readUsingJackson();;
    }

}
