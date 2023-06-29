package hust.workattendanceapp.controller.worker;
import hust.workattendanceapp.validate.TimeFormatValidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditDataRequestPopUpControllerTest {
    @Test
        // valid time format
    void tc1() {
        assertFalse(TimeFormatValidate.checkDataError("00"));
    }

    // valid time format
    @Test
    void tc2() {
        assertTrue(TimeFormatValidate.checkDataError("10:00"));
    }

    // Valid hour boundary
    @Test
    void tc3() {
        assertTrue(TimeFormatValidate.checkDataError("13:00"));
    }

    // Invalid hour boundary
    @Test
    void tc4() {
        assertFalse(TimeFormatValidate.checkDataError("24:00"));
    }

    // Invalid minute
    @Test
    void tc5() {
        assertFalse(TimeFormatValidate.checkDataError("23:61"));
    }

    // Invalid minute
    @Test
    void tc6() {
        assertFalse(TimeFormatValidate.checkDataError("15:66"));
    }

    // Invalid String
    @Test
    void tc7() {
        assertFalse(TimeFormatValidate.checkDataError("abc abc"));
    }

    @Test
    void tc8() {
        assertFalse(TimeFormatValidate.checkDataError(null));
    }


}
