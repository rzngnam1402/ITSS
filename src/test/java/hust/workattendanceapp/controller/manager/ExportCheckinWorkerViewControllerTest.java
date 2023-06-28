package hust.workattendanceapp.controller.manager;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class ExportCheckinWorkerViewControllerTest {
    ExportCheckinWorkerViewController checkinWorker = new ExportCheckinWorkerViewController();

    //Valid Month
    @Test
    void tc1() {assertTrue(checkinWorker.checkMonthString("10"));}

    //Valid Month Boundary
    @Test
    void tc2() {assertFalse(checkinWorker.checkMonthString("13"));}

    //Invalid Month Boundary
    @Test
    void tc3() {assertFalse(checkinWorker.checkMonthString("0"));}

    //Valid String
    @Test
    void tc4() {assertTrue(checkinWorker.checkMonthString("01"));}

    //Invalid String
    @Test
    void tc5() {assertFalse(checkinWorker.checkMonthString("123a"));}
    @Test
    void tc6() {assertFalse(checkinWorker.checkMonthString("abc"));}
}