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
    void tc2() {assertTrue(checkinWorker.checkMonthString("12"));}

    //Invalid Month Boundary
    @Test
    void tc3() {assertFalse(checkinWorker.checkMonthString("0"));}

    //Valid String
    @Test
    void tc4() {assertTrue(checkinWorker.checkMonthString("01"));}

    //Invalid String
    @Test
    void tc5() {assertFalse(checkinWorker.checkMonthString("123a"));}

    //Invalid String
    @Test
    void tc6() {assertFalse(checkinWorker.checkMonthString("abc"));}

    //Invalid String
    @Test
    void tc7() {assertFalse(checkinWorker.checkMonthString("1,"));}
}