package hust.workattendanceapp.model.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataToImport {
    public DataToImport(String employeeID, String employeeName, String date, String checkinTime, String checkoutTime, CheckBox select) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.select = new CheckBox();
    }

    private String employeeID;
    private String employeeName;
    private String date;
    private String checkinTime;
    private String checkoutTime;
    private CheckBox select;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public static ObservableList getImportList(String path) throws IOException {
        ObservableList<DataToImport> ImportList = FXCollections.observableArrayList();
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date toDate = dateFormat.parse(row[2]);
                ImportList.add(new DataToImport(row[0], row[1], row[2], row[3], row[4], null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImportList;
    }
}
