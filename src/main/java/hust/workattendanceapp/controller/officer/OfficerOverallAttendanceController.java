package hust.workattendanceapp.controller.officer;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.officer.OfficerOverallAttendanceData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OfficerOverallAttendanceController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<OfficerOverallAttendanceData> table;

    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> dateColumn;
    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> mondayColumn;
    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> tuesdayColumn;
    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> wednesdayColumn;
    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> thursdayColumn;
    @FXML
    private TableColumn<OfficerOverallAttendanceData, String> fridayColumn;
    ObservableList<OfficerOverallAttendanceData> dataList;

    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToExportCheckinListUnit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_LIST_UNIT_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToImportDataView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.IMPORT_DATA_BY_EXCEL_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.LOGIN_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataList = OfficerOverallAttendanceData.getData();
        dateColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("session"));
        mondayColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("monday"));
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("tuesday"));
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("wednesday"));
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("thursday"));
        fridayColumn.setCellValueFactory(new PropertyValueFactory<OfficerOverallAttendanceData, String>("friday"));
        table.setItems(dataList);
    }
}
