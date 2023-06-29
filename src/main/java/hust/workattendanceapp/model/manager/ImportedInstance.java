package hust.workattendanceapp.model.manager;

import javafx.scene.control.CheckBox;

import java.util.Date;

public class ImportedInstance {
    public ImportedInstance(String employeeID, String employeeName, String date, String checkinTime, String checkoutTime) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
    }
    private String employeeID;
    private String employeeName;
    private String date;
    private String checkinTime;
    private String checkoutTime;
}
