package hust.workattendanceapp.controller.officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class OfficerOverallAttendance1Controller {

    @FXML
    private DatePicker date;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button filter;

    @FXML
    private TableColumn<?, ?> fridayColumn;

    @FXML
    private TableColumn<?, ?> fridayColumn1;

    @FXML
    private TableColumn<?, ?> mondayColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> thursdayColumn;

    @FXML
    private TableColumn<?, ?> tuesdayColumn;

    @FXML
    private TableColumn<?, ?> wednesdayColumn;

    @FXML
    void filterTimekeepingByMonth(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void switchToExportCheckinListUnit(ActionEvent event) {

    }

    @FXML
    void switchToHomepage(ActionEvent event) {

    }

    @FXML
    void switchToImportDataView(ActionEvent event) {

    }

}
