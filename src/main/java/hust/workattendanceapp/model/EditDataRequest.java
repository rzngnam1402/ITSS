package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EditDataRequest {
    public EditDataRequest(int requestID, String employeeName, String employeeID, String employeeSex, String date, String status) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.date = date;
        this.status = status;
    }

    private int requestID;
    private String employeeID;
    private String employeeName;
    private String employeeSex;
    private String date;
    private String status;

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
        editDataRequestsList.add(new EditDataRequest(1, "Le Giang Nam",
                "20205004", "male", "22-06-2023", "pending"));
        editDataRequestsList.add(new EditDataRequest(2, "Do Khanh Ly",
                "202050377", "female", "21-06-2023", "pending"));
        editDataRequestsList.add(new EditDataRequest(3, "Do Chi Thanh",
                "20205025", "male", "20-06-2023", "rejected"));
        editDataRequestsList.add(new EditDataRequest(4, "Bui Minh Dung",
                "20205025", "male", "19-06-2023", "approved"));
        editDataRequestsList.add(new EditDataRequest(5, "Nguyen Ngoc Tu",
                "20205025", "female", "18-06-2023", "approved"));
        return editDataRequestsList;
    }
}
