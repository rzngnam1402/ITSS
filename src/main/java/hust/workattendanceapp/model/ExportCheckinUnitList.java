package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        exportCheckinUnitList.add(new ExportCheckinUnitList(1, "Le Giang Nam",
                20205004, "male"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(2, "Do Khanh Ly",
                202050377, "female"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(3, "Do Chi Thanh",
                20205025, "male"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(4, "Bui Minh Dung",
                20205025, "male"));
        exportCheckinUnitList.add(new ExportCheckinUnitList(5, "Nguyen Ngoc Tu",
                20205025, "female"));
        return exportCheckinUnitList;
    }
}
