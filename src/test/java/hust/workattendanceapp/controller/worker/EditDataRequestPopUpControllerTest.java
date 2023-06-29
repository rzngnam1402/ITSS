package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.model.worker.EditDataRequestForm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditDataRequestPopUpControllerTest {
    @Test
        // valid time format
    void tc1() {
        assertFalse(EditDataRequestForm.checkDataError("00:00", "13:23", "2", null));
    }

    // valid time format
    @Test
    void tc2() {
        assertTrue(EditDataRequestForm.checkDataError("10:00", "11:00", "17:00", "19:00"));
    }

    // Valid hour boundary
    @Test
    void tc3() {
        assertTrue(EditDataRequestForm.checkDataError("13:00", "14:15", "19:00", "20:00"));
    }

    // Invalid hour boundary
    @Test
    void tc4() {
        assertFalse(EditDataRequestForm.checkDataError("13:00", "14:00", "20:00", "24:00"));
    }

    // Invalid minute
    @Test
    void tc5() {
        assertFalse(EditDataRequestForm.checkDataError("13:66", "15:77", "20:00", "23:61"));
    }

    // Invalid minute
    @Test
    void tc6() {
        assertFalse(EditDataRequestForm.checkDataError("15:66", "15:54", "23:00", "22:61"));
    }

    // Invalid String
    @Test
    void tc7() {
        assertFalse(EditDataRequestForm.checkDataError("13:66", "hello", "20:00", "23:61"));
    }

    @Test
    void tc8() {
        assertFalse(EditDataRequestForm.checkDataError("13:66", null, "20:00", "23:61"));
    }


}
