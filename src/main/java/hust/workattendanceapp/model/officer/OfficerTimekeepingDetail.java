package hust.workattendanceapp.model.officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfficerTimekeepingDetail implements IOfficerTimekeepingDetail {

    IOfficerTimekeepingOverview officerTimekeepingOverview = new OfficerTimekeepingOverview();

    @Override
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime) {
        boolean isReturningEarly = returningTime.getHour()*3600 + returningTime.getMinute()*60 + returningTime.getSecond() < endTime.getHour()*3600 + endTime.getMinute()*60 + endTime.getSecond();
        if(isReturningEarly) {
            int total = endTime.getHour() * 3600 + endTime.getMinute() * 60 - returningTime.getHour() * 3600 + returningTime.getMinute() * 60;
            return (int) total / 3600 + ":" + (total - 3600 * (int) total / 3600) / 60;
        }
        return "No";
    }

    @Override
    public String getComeLateTime(LocalDateTime comingTime, LocalDateTime startTime) {
        boolean isComeLate = comingTime.getHour()*3600 + comingTime.getMinute()*60 + comingTime.getSecond()
                > startTime.getHour()*3600 + startTime.getMinute()*60 + startTime.getSecond();
        if(isComeLate)
        {
            int total = comingTime.getHour() * 3600 + comingTime.getMinute() * 60 - comingTime.getHour() * 3600 + comingTime.getMinute() * 60;
            return (int)total/3600 + ":" + (total- 3600*(int)total/3600)/60;
        }
        else
            return "No";
    }

    @Override
    public ObservableList<OfficerOverallAttendance1Data> getTimekeepingDetailByDay(LocalDate time, LocalDateTime start, LocalDateTime end) {
        ObservableList<OfficerOverallAttendance1Data> timekeepingDetails = FXCollections.observableArrayList();

        return timekeepingDetails;
    }

}
