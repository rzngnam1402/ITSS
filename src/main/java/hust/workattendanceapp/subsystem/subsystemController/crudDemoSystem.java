package hust.workattendanceapp.subsystem.subsystemController;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import hust.workattendanceapp.model.EditDataRequest;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//CRUD with json
public class crudDemoSystem {
    public static String insertOne(String filePath, Object data) throws IOException {
        ArrayList<Object> list = null;
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            Type type = new TypeToken<ArrayList<Object>>() {
            }.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<Object>();
            list.add(data);
        } else {
            list.add(data);
        }
        Path path = Paths.get(filePath);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gsonWrite = new GsonBuilder().setPrettyPrinting().create();

            JsonElement tree = gson.toJsonTree(list);
            gsonWrite.toJson(tree, writer);
        }
        return "Inserted to json";
    }

    public static ArrayList<Object> getData(String filePath) {
        ArrayList<Object> list = new ArrayList<>() {
        };
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            Type type = new TypeToken<ArrayList<Object>>() {
            }.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String insertMany(String filePath, ArrayList<Object> dataset) throws IOException {
        ArrayList<Object> list = null;
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            Type type = new TypeToken<ArrayList<Object>>() {
            }.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<Object>();
            list.addAll(dataset);
        } else {
            list.addAll(dataset);
        }

        Path path = Paths.get(filePath);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gsonWrite = new GsonBuilder().setPrettyPrinting().create();

            JsonElement tree = gson.toJsonTree(list);
            gsonWrite.toJson(tree, writer);
        }
        return "Inserted to json";
    }

    public static void main(String[] args) throws IOException {
        EditDataRequest test1 = new EditDataRequest(6, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending",
                "12:05", "12:00", "17:38", "17:40",
                "I want to change my checkin time because I checked in  the wrong time.");
        EditDataRequest test2 = new EditDataRequest(7, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending",
                "12:05", "12:00", "17:38", "17:40",
                "I want to change my checkin time because I checked in  the wrong time.");
        EditDataRequest test3 = new EditDataRequest(8, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending",
                "12:05", "12:00", "17:38", "17:40",
                "I want to change my checkin time because I checked in  the wrong time.");
        ArrayList<Object> testing = new ArrayList<Object>();
        testing.add(test1);
        testing.add(test2);
        testing.add(test3);

        //Add directly to json
        crudDemoSystem.insertOne("src/main/java/hust/workattendanceapp/subsystem/data/test.json", test3);
        crudDemoSystem.insertMany("src/main/java/hust/workattendanceapp/subsystem/data/test.json", testing);


        //Controller handle
        ArrayList<Object> data = crudDemoSystem.getData("src/main/java/hust/workattendanceapp/subsystem/data/test.json");
        Gson gson = new Gson();
        String jsonString = gson.toJson(data.get(0));
        EditDataRequest editDataRequest = gson.fromJson(jsonString,EditDataRequest.class);
        System.out.println(editDataRequest.getEmployeeID());
    }
}

