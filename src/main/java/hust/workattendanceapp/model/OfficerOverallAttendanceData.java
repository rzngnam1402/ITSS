package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OfficerOverallAttendanceData {
    public OfficerOverallAttendanceData(String session, String monday, String tuesday,
                                        String wednesday, String thursday, String friday) {
        this.session = session;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    private String session;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    public static ObservableList getData() {
        ObservableList<OfficerOverallAttendanceData> dataList = FXCollections.observableArrayList();
        dataList.add(new OfficerOverallAttendanceData("Morning Session", "Yes", "Yes",
                "Yes", "Yes", "Yes"));
        dataList.add(new OfficerOverallAttendanceData("Afternoon Session", "No", "Yes",
                "Yes", "No", "Yes"));
        dataList.add(new OfficerOverallAttendanceData("Hours Late", "0.25", "0",
                "0", "0", "0.2"));
        dataList.add(new OfficerOverallAttendanceData("Hours Early Leave", "0.5", "0",
                "0", "0.5", "0.2"));
        return dataList;
    }
}
