package hust.workattendanceapp.subsystem.subsystemController;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import hust.workattendanceapp.model.worker.EditDataRequestForm;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//CRUD with json
public class CRUDSystem {
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

    public static ArrayList<EditDataRequestForm> getData(String filePath, String employeeID) {
        ArrayList<EditDataRequestForm> list = new ArrayList<>() ;
        ArrayList<EditDataRequestForm> returnList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            Type type = new TypeToken<ArrayList<EditDataRequestForm>>() {
            }.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(EditDataRequestForm editDataRequestForm: list){
            if (editDataRequestForm.getEmployeeID().equals(employeeID)){
                returnList.add(editDataRequestForm);
            }
        }
        return returnList;
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


    }
}

