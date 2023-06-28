package hust.workattendanceapp.model.officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OfficerOverallAttendance1Data {

    private int date;
    private String startTime;
    private String endTime;
    private String late;
    private String early;

    public OfficerOverallAttendance1Data(int date, String startTime, String endTime, String late, String early) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.late = late;
        this.early = early;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getEarly() {
        return early;
    }

    public void setEarly(String early) {
        this.early = early;
    }


    public static ObservableList getData() {
        ObservableList<OfficerOverallAttendance1Data> dataListOfficer = FXCollections.observableArrayList();

        dataListOfficer.add(new OfficerOverallAttendance1Data(1, "7:30","16:30", "NO", "YES"));

        return dataListOfficer;

    }
}
