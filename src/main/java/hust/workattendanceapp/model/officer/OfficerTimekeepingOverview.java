package hust.workattendanceapp.model.officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

        try {
            List<TestDateReader> data = OfficerOverallAttendance1Data.test();
            List<TestDateReader> resultDatas = data.stream().filter((testDateReader -> {
                return testDateReader.getDate().getMonth().equals(fromDate.getMonth()) &&
                    testDateReader.getDate().getYear() == fromDate.getYear();
            })).collect(Collectors.toList());

            for (TestDateReader oneDate : resultDatas) {
                OfficerOverallData result = new OfficerOverallData(
                        oneDate.getStringDate(),
                        oneDate.getStringStartTime(),
                        oneDate.getStringEndTime(),
                        this.getComeLateTime(start, oneDate.getStartTime()),
                        this.getReturnEarlyTime(end, oneDate.getEndTime())
                );
                System.out.println(result.toString());
                timekeepingOverviews.add(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //data = OfficerOverallAttendance1Data.test();

        return timekeepingOverviews;
    }

}
