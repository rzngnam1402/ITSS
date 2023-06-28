package hust.workattendanceapp.controller.officer;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.officer.IOfficerTimekeepingOverview;
import hust.workattendanceapp.model.officer.OfficerOverallAttendance1Data;
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

    ObservableList<OfficerOverallAttendance1Data> dataList;

    public static LocalDate localDate = LocalDate.now();
    IOfficerTimekeepingOverview officerTimekeepingOverview = new OfficerTimekeepingOverview();
    ObservableList<OfficerOverallAttendance1Data> timekeepingOverviews = FXCollections.observableArrayList();

    LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 8, 00, 0);
    LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 17, 30, 0);

    @FXML
    private DatePicker date;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, String> dateColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, String> startTimeColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, String> endTimeColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, String> lateColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, String> earlyColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, Button> viewColumn;

    @FXML
    private TableColumn<OfficerOverallAttendance1Data, Button> requestColumn;

    @FXML
    private TableView<OfficerOverallAttendance1Data> table;

    @FXML
    private Button filter;


    @FXML
    void filterTimekeepingByMonth(ActionEvent event) {
        LocalDate selectDate = date.getValue();
        OfficerOverallAttendance1Controller.localDate = selectDate;
        timekeepingOverviews = officerTimekeepingOverview.getTimekeepingByMonth(OfficerOverallAttendance1Controller.localDate, startTime, endTime);
        table.setItems(timekeepingOverviews);
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

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        dataList = OfficerOverallAttendance1Data.getData();

        dateColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendance1Data, String>("date"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendance1Data, String>("startTime"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendance1Data, String>("endTime"));
        lateColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendance1Data, String>("late"));
        earlyColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendance1Data, String>("early"));

        table.setItems(dataList);

        viewColumn.setCellFactory(createButtonCell("View", "view-butotn"));

        requestColumn.setCellFactory(createButtonCell("Request", "request-button"));

        timekeepingOverviews = officerTimekeepingOverview.getTimekeepingByMonth(OfficerOverallAttendance1Controller.localDate, startTime, endTime);
        table.setItems(timekeepingOverviews);

    }

    private Callback<TableColumn<OfficerOverallAttendance1Data, Button>, TableCell<OfficerOverallAttendance1Data, Button>>
    createButtonCell(String buttonText, String buttonStyle) {
        return column -> new TableCell<OfficerOverallAttendance1Data, Button>() {
            private final Button button = new Button(buttonText);

            {
                button.getStyleClass().add(buttonStyle);
                button.setOnAction(event -> {
                    OfficerOverallAttendance1Data timekeepingOverview = getTableRow().getItem();

                    if(buttonStyle.equals("View-button")) {
                        OfficerOverallAttendance1Data timekeepingOverview1 = getTableRow().getItem();
                        localDate = LocalDate.of(date.getValue().getYear(), date.getValue().getMonth(), timekeepingOverview1.getDate());

                        // lay doi tuong stage hien tai
                    } else System.out.println("Request Butotn");
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


}
