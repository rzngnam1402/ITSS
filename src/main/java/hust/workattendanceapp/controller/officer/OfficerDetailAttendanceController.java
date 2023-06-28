package hust.workattendanceapp.controller.officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class OfficerDetailAttendanceController {

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Pane filter;

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
    void backToDetailPage(ActionEvent event) {

    }

    @FXML
    void filterTimekeepingByMonth(MouseEvent event) {

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
