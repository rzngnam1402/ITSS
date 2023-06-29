package hust.workattendanceapp.controller.officer;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.officer.IOfficerTimekeepingOverview;
import hust.workattendanceapp.model.officer.OfficerOverallAttendance1Data;
import hust.workattendanceapp.model.officer.OfficerOverallData;
import hust.workattendanceapp.model.officer.OfficerTimekeepingOverview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class OfficerOverallAttendance1Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<OfficerOverallData> dataList;

    public static LocalDate localDate = LocalDate.now();
    IOfficerTimekeepingOverview officerTimekeepingOverview = new OfficerTimekeepingOverview();
    ObservableList<OfficerOverallData> timekeepingOverviews = FXCollections.observableArrayList();

    LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 8, 00, 0);
    LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 17, 30, 0);

    @FXML
    private DatePicker date;

    @FXML
    private TableColumn<OfficerOverallData, Integer> dateColumn;

    @FXML
    private TableColumn<OfficerOverallData, String> startTimeColumn;

    @FXML
    private TableColumn<OfficerOverallData, String> endTimeColumn;

    @FXML
    private TableColumn<OfficerOverallData, String> lateColumn;

    @FXML
    private TableColumn<OfficerOverallData, String> earlyColumn;

    @FXML
    private TableColumn<OfficerOverallData, Button> viewColumn;

    @FXML
    private TableColumn<OfficerOverallData, Button> requestColumn;

    @FXML
    private TableView<OfficerOverallData> table;

    @FXML
    private Button filter;


    @FXML
    void filterTimekeepingByMonth(ActionEvent event) {
        LocalDate selectDate = date.getValue();
        OfficerOverallAttendance1Controller.localDate = selectDate;
        timekeepingOverviews = officerTimekeepingOverview.getTimekeepingByMonth(OfficerOverallAttendance1Controller.localDate, startTime, endTime);
        table.setItems(timekeepingOverviews);
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {

        dataList = OfficerOverallAttendance1Data.getData();

        dateColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallData, Integer>("date"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallData, String>("startTime"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallData, String>("endTime"));
        lateColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallData, String>("comeLate"));
        earlyColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallData, String>("returnEarly"));

        date.setValue(LocalDate.now());

        viewColumn.setCellFactory(createButtonCell("View", "view-button"));

        requestColumn.setCellFactory(createButtonCell("Request", "request-button"));

        timekeepingOverviews = officerTimekeepingOverview.getTimekeepingByMonth(OfficerOverallAttendance1Controller.localDate, startTime, endTime);
        table.setItems(timekeepingOverviews);

    }

    private Callback<TableColumn<OfficerOverallData, Button>, TableCell<OfficerOverallData, Button>>
    createButtonCell(String buttonText, String buttonStyle) {
        return column -> new TableCell<OfficerOverallData, Button>() {
            private final Button button = new Button(buttonText);

            {
                button.getStyleClass().add(buttonStyle);
                button.setOnAction(event -> {
                    OfficerOverallData timekeepingOverview = getTableRow().getItem();

                    if(buttonStyle.equals("View-button")) {
                        OfficerOverallData timekeepingOverview1 = getTableRow().getItem();
                        //localDate = LocalDate.of(date.getValue().getYear(), date.getValue().getMonth(), timekeepingOverview1.getDate());



                        // lay doi tuong stage hien tai
                    } else System.out.println("Request Button");
                });
            }

            @Override
            protected void updateItem (Button item, boolean empty) {
                super.updateItem(item, empty);
                if(empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        };
    }

    @FXML
    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToExportCheckinListUnit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_LIST_UNIT_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToImportDataView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.IMPORT_DATA_BY_EXCEL_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.LOGIN_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
