package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.UUID;

public class EditDataRequestForm {
    public EditDataRequestForm() {
    }

    private String requestID;
    private String employeeID;
    private String date;
    private String status;
    private String oldCheckinTime;
    private String newCheckinTime;
    private String oldCheckoutTime;
    private String newCheckoutTime;
    public String description;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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
}
