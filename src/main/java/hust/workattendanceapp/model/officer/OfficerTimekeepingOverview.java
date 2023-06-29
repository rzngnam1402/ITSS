package hust.workattendanceapp.model.officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OfficerTimekeepingOverview implements IOfficerTimekeepingOverview {

    @Override
    public int getDay(int month, int year) {
        List<Integer> month31day = new ArrayList<>(List.of(1,3,5,7,8,10,12));
        List<Integer> month30day = new ArrayList<>(List.of(4,6,9,11));

        if(month31day.contains(month)) return 31;
        if(month30day.contains(month)) return 30;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 29;
        } else return 28;
    }

    @Override
    public String getStartTime(LocalDateTime time) {
        return time.getHour()+":"+time.getMinute();
    }

    @Override
    public String getEndTime(LocalDateTime time) {
        return time.getHour()+":"+time.getMinute();
    }

    @Override
    public String getReturnEarlyTime(LocalDateTime returningTime, LocalDateTime endTime) {
        boolean isReturningEarly = returningTime.getHour()*3600 + returningTime.getMinute()*60 + returningTime.getSecond()
                < endTime.getHour()*3600 + endTime.getMinute()*60 + endTime.getSecond();
        if(isReturningEarly)
            return "Yes";
        else
            return "No";
    }

    @Override
    public String getComeLateTime(LocalDateTime comingTime, LocalDateTime startTime) {
        boolean isComeLate = comingTime.getHour()*3600 + comingTime.getMinute()*60 + comingTime.getSecond()
                > startTime.getHour()*3600 + startTime.getMinute()*60 + startTime.getSecond();
        if(isComeLate)
            return "Yes";
        else
            return "No";
    }

    @Override
    public ObservableList<OfficerOverallData> getTimekeepingByMonth(LocalDate fromDate, LocalDateTime start, LocalDateTime end) {
        ObservableList<OfficerOverallData> timekeepingOverviews = FXCollections.observableArrayList();

//        List<OfficerOverallAttendance1Data> datas = OfficerOverallAttendance1Data.getData();
//        for(OfficerOverallAttendance1Data data : datas) {
//            System.out.println(data.getStringDate() + data.getStringEndTime() + data.getStringStartTime());
//        }
        try {
            List<TestDateReader> data = OfficerOverallAttendance1Data.test();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        //data = OfficerOverallAttendance1Data.test();

        return timekeepingOverviews;
    }

}
