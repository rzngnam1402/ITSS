package hust.workattendanceapp.model.officer;

public class OfficerOverallData {
    private String date;
    private String startTime;
    private String endTime;
    private String comeLate;
    private String returnEarly;

    public OfficerOverallData() {}

    public OfficerOverallData(String date, String startTime, String endTime, String comeLate, String returnEarly) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.comeLate = comeLate;
        this.returnEarly = returnEarly;

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

    public String getComeLate() {
        return comeLate;
    }

    public void setComeLate(String comeLate) {
        this.comeLate = comeLate;
    }

    public String getReturnEarly() {
        return returnEarly;
    }

    public void setReturnEarly(String returnEarly) {
        this.returnEarly = returnEarly;
    }

    @Override
    public String toString() {
        return "OfficerOverallData{" +
                "date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", comeLate='" + comeLate + '\'' +
                ", returnEarly='" + returnEarly + '\'' +
                '}';
    }
}
