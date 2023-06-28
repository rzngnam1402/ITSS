package hust.workattendanceapp.model.officer;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IOfficerTimekeepingDetail {
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime);
    public String getComeLateTime(LocalDateTime comingTime, LocalDateTime startTime);

    public ObservableList<OfficerOverallAttendance1Data> getTimekeepingDetailByDay(LocalDate time, LocalDateTime start, LocalDateTime end);
}
