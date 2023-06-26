package hust.workattendanceapp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class EditDataRequest {
    public EditDataRequest(int requestID, String employeeName, String employeeID,
                           String employeeSex, String date, String status,
                           String oldCheckinTime, String newCheckinTime,
                           String oldCheckoutTime, String newCheckoutTime,
                           String description) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.date = date;
        this.status = status;
        this.oldCheckinTime = oldCheckinTime;
        this.newCheckinTime = newCheckinTime;
        this.oldCheckoutTime = oldCheckoutTime;
        this.newCheckoutTime = newCheckoutTime;
        this.description = description;
    }

    private int requestID;
    private String employeeID;

    public String getOldCheckinTime() {
        return oldCheckinTime;
    }

    public void setOldCheckinTime(String oldCheckinTime) {
        this.oldCheckinTime = oldCheckinTime;
    }

    public String getNewCheckinTime() {
        return newCheckinTime;
    }

    public void setNewCheckinTime(String newCheckinTime) {
        this.newCheckinTime = newCheckinTime;
    }

    public String getOldCheckoutTime() {
        return oldCheckoutTime;
    }

    public void setOldCheckoutTime(String oldCheckoutTime) {
        this.oldCheckoutTime = oldCheckoutTime;
    }

    public String getNewCheckoutTime() {
        return newCheckoutTime;
    }

    public void setNewCheckoutTime(String newCheckoutTime) {
        this.newCheckoutTime = newCheckoutTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String employeeName;
    private String employeeSex;
    private String date;
    private String status;
    private String oldCheckinTime;
    private String newCheckinTime;
    private String oldCheckoutTime;
    private String newCheckoutTime;
    public String description;

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

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

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ObservableList getEditRequestList() {
        ObservableList<EditDataRequest> editDataRequestsList = null;
        Gson gson = new Gson();
        try {
            ArrayList<EditDataRequest> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/EditDataRequest.json");
            Type type = new TypeToken<ArrayList<EditDataRequest>>() {
            }.getType();
            alist = gson.fromJson(reader, type);
            editDataRequestsList = FXCollections.observableArrayList(alist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return editDataRequestsList;
    }
}
