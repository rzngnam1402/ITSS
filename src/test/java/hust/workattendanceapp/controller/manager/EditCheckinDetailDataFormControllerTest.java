package hust.workattendanceapp.controller.manager;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class EditCheckinDetailDataFormControllerTest {
    EditCheckinDetailDataFormController editDataForm = new EditCheckinDetailDataFormController();

    // valid 12 format hour
    @Test
    void tc1() {
        assertTrue(editDataForm.checkTimeField("12:12"));
    }

    // valid 24 format hour
    @Test
    void tc2() {
        assertTrue(editDataForm.checkTimeField("23:54"));
    }

    // Valid hour boundary
    @Test
    void tc3() {
        assertTrue(editDataForm.checkTimeField("00:00"));
    }

    // Invalid hour boundary
    @Test
    void tc4() {
        assertFalse(editDataForm.checkTimeField("24:00"));
    }

    // Invalid minute
    @Test
    void tc5() {
        assertFalse(editDataForm.checkTimeField("23:66"));
    }

    // Invalid minute
    @Test
    void tc6() {
        assertFalse(editDataForm.checkTimeField("23:60"));
    }

    // Invalid String
    @Test
    void tc7() {
        assertFalse(editDataForm.checkTimeField("ab:30"));
    }

    @Test
    void tc8() {
        assertFalse(editDataForm.checkTimeField("12:ab"));
    }

    @Test
    void tc9() {
        assertFalse(editDataForm.checkTimeField("abc"));
    }

    // Invalid null String
    @Test
    void tc10() {
        assertFalse(editDataForm.checkTimeField(null));
    }
}