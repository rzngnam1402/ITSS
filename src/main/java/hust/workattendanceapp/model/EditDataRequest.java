package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.PrivateKey;

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
        ObservableList<EditDataRequest> editDataRequestsList = FXCollections.observableArrayList();
        // get data from json file
        editDataRequestsList.add(new EditDataRequest(5, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending",
                "12:05", "12:00", "17:38", "17:40",
                "I want to change my checkin time because I checked in  the wrong time."));
        editDataRequestsList.add(new EditDataRequest(4, "Do Khanh Ly",
                "20200377", "female", "21-06-2023", "pending",
                "13:05", "13:00", "17:00", "17:00",
                "I was late to work for 5 minutes. Please edit my attendance time. Thank you for understanding"
        ));
        editDataRequestsList.add(new EditDataRequest(3, "Do Chi Thanh",
                "20205025", "male", "20-06-2023", "rejected",
                "14:00", "13:00", "17:00", "17:00",
                "Sorry for the inconvenience caused by me, i checked in the wrong time"));
        editDataRequestsList.add(new EditDataRequest(2, "Bui Minh Dung",
                "20205070", "male", "19-06-2023", "approved",
                "13:05", "13:05", "18:00", "18:30",
                "I checked out early for 30 minutes. Please change my checkout time. Thank you !"));
        editDataRequestsList.add(new EditDataRequest(1, "Nguyen Ngoc Tu",
                "20205135", "female", "18-06-2023", "approved",
                "12:00", "12:00", "18:40", "18:00",
                "I checked out late for 40 minutes. Please change my checkout time. Thank you !"));
        return editDataRequestsList;
    }
}
