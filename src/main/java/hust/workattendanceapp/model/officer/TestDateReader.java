package hust.workattendanceapp.model.officer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestDateReader {
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStringDate() {
        return this.date.getDayOfMonth() + "";
    }

    public String getStringStartTime() {
        return this.startTime.getHour()+":"+this.startTime.getMinute();
    }

    public String getStringEndTime() {
        return this.endTime.getHour()+":"+this.startTime.getMinute();
    }

    public TestDateReader(LocalDate date, LocalDateTime startTime, LocalDateTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TestDateReader() {}
}
