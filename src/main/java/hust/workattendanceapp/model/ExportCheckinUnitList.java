package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        exportCheckinUnitList.add(new ExportCheckinUnitList(1, "Intro to AI",
                12, "Do Chi Thanh"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(2, "UX UI",
                43, "Le Giang Nam"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(3, "ITSS",
                12, "Chi Thanh Do"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(4, "Lich su Dang",
                34, "Dung Minh Bui"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(5, "Project 1",
                76, "Adudu"));
        return exportCheckinUnitList;
    }
}
