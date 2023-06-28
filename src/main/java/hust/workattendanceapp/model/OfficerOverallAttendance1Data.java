package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OfficerOverallAttendance1Data {

    private String date;
    private String startTime;
    private String endTime;
    private String late;
    private String early;
    private String view;
    private String request;

    public OfficerOverallAttendance1Data(String date, String startTime, String endTime, String late, String early,
            String view, String request) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.late = late;
        this.early = early;
        this.view = view;
        this.request = request;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

//    public static ObservableList getData() {
//        ObservableList<OfficerOverallAttendance1Data> dataListOfficer = FXCollections.observableArrayList();
//
//        dataListOfficer.add(new OfficerOverallAttendance1Data())
//
//        return dataListOfficer;
//
//    }
}
