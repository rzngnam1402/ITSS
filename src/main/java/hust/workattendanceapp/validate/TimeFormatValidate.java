package hust.workattendanceapp.validate;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TimeFormatValidate {
    public static boolean checkDataError(String time) {
        if (checkTimeField(time))
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean checkTimeField(String timeToCheck) {
        System.out.println(timeToCheck);
        try {
            LocalTime.parse(timeToCheck);
            System.out.println("Valid time string: " + timeToCheck);
            return true;
        } catch (DateTimeParseException | NullPointerException e) {
            System.out.println("Invalid time string: " + timeToCheck);
            return false;
        }
    }
}
