package hust.workattendanceapp.subsystem.subsystemController;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import hust.workattendanceapp.model.EditDataRequest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

//CRUD with json
public class crudDemoSystem {
    public static String insertOne(String filePath, Object data){
        Gson gson = new Gson();
        String insertData = gson.toJson(data);
        return "Data is add to Json";
    }

    public static void main(String[] args) throws IOException {
        EditDataRequest test= new EditDataRequest(5, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending",
                "12:05", "12:00", "17:38", "17:40",
                "I want to change my checkin time because I checked in  the wrong time.");
        Writer writer = Files.newBufferedWriter(Paths.get("D://Slide-and-school//ITSS//ITSS//src//main//java//hust//workattendanceapp//subsystem//data//test.java"));

    }
}
