package hust.workattendanceapp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class ExportCheckinUnitList {
    public ExportCheckinUnitList(int sTT, String unitName, int numOfEmployees, String unitManager) {
        this.sTT = sTT;
        this.unitName = unitName;
        this.numOfEmployees = numOfEmployees;
        this.unitManager = unitManager;
    }

    private int sTT;
    private String unitName;
    private int numOfEmployees;
    private String unitManager;

    public int getSTT() {
        return sTT;
    }

    public void setSTT(int sTT) {
        this.sTT = sTT;
    }
    public String getUnitName() {
        return unitName;
    }

    public void setNumOfEmployees(String unitName) {
        this.unitName = unitName;
    }
    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {this.numOfEmployees = numOfEmployees;}
    public String getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(String unitManager) {
        this.unitManager = unitManager;
    }


    public static ObservableList getUnitList() {
        ObservableList<ExportCheckinUnitList> exportCheckinUnitList = FXCollections.observableArrayList();
        // get data from json file
        Gson gson = new Gson();
        try {
            ArrayList<ExportCheckinUnitList> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/UnitList.json");
            Type type = new TypeToken<ArrayList<ExportCheckinUnitList>>() {
            }.getType();
            alist = gson.fromJson(reader, type);
            exportCheckinUnitList = FXCollections.observableArrayList(alist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportCheckinUnitList;
    }
}
