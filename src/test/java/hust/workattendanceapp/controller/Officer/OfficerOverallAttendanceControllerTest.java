package hust.workattendanceapp.controller.Officer;

import hust.workattendanceapp.controller.officer.OfficerOverallAttendance1Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OfficerOverallAttendanceControllerTest {
    OfficerOverallAttendance1Controller viewOfficerOverall = new OfficerOverallAttendance1Controller();
    //Valid Month
    @Test
    void tc1() {assertTrue(viewOfficerOverall.checkTimeString("10", "2020"));}
    //Valid Month Boundary
    @Test
    void tc2() {assertTrue(viewOfficerOverall.checkTimeString("12", "2020"));}
    //Invalid Month Boundary
    @Test
    void tc3() {assertFalse(viewOfficerOverall.checkTimeString("0", "2020"));}
    //Valid String
    @Test
    void tc4() {assertTrue(viewOfficerOverall.checkTimeString("01", "2020"));}
    //Invalid String
    @Test
    void tc5() {assertFalse(viewOfficerOverall.checkTimeString("1a", "2020"));}
    //Invalid String
    @Test
    void tc6() {assertFalse(viewOfficerOverall.checkTimeString("2''", "2020"));}
    //Invalid Year Boundary
    @Test
    void tc7() {assertFalse(viewOfficerOverall.checkTimeString("0", "0"));}
    //Valid String
    @Test
    void tc8() {assertTrue(viewOfficerOverall.checkTimeString("3", "002020"));}
    //Invalid String
    @Test
    void tc9() {assertFalse(viewOfficerOverall.checkTimeString("1a", "2020ab"));}

}
