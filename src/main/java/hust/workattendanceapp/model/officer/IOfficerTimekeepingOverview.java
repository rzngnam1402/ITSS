package hust.workattendanceapp.model.officer;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IOfficerTimekeepingOverview {

    public int getDay(int month, int year);
    public String getStartTime(LocalDateTime time);
    public String getEndTime(LocalDateTime time);
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime);
    public String getComeLateTime(LocalDateTime commingTime, LocalDateTime startTime);

    public ObservableList<OfficerOverallData> getTimekeepingByMonth(LocalDate time, LocalDateTime start, LocalDateTime end);

}
