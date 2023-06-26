package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.ExportCheckinDetail;
import hust.workattendanceapp.model.ExportCheckinUnitList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ExportCheckinDetailViewController  implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<ExportCheckinDetail> table;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> unitNumberDetail;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> workerSTTColumn;
    @FXML
    private TableColumn<ExportCheckinDetail, String> workerNameColumn;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> workerNumberColumn;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> workerMonthColumn;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> workerWorkHourColumn;
    @FXML
    private TableColumn<ExportCheckinDetail, Integer> workerOTHourColumn;
    @FXML
    ObservableList<ExportCheckinDetail> checkinDetails;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void createNewDetail(ExportCheckinUnitList detailUnit) {
        checkinDetails = ExportCheckinDetail.getCheckinDetail();
        ObservableList<ExportCheckinDetail> exportCheckinDetails = FXCollections.observableArrayList();
        for (ExportCheckinDetail eachstring : checkinDetails) {
            if (eachstring.getUnitNumberDetail() == detailUnit.getSTT()) {
                exportCheckinDetails.add(new ExportCheckinDetail(eachstring.getUnitNumberDetail(), eachstring.getWorkerSTT(), eachstring.getWorkerName(),eachstring.getWorkerNumber(), eachstring.getWorkerMonth(), eachstring.getWorkerWorkHour(), eachstring.getWorkerOTHour()));
            }
        }
        workerSTTColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerSTT"));
        workerNameColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, String>("workerName"));
        workerNumberColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerNumber"));
        workerMonthColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerMonth"));
        workerWorkHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerWorkHour"));
        workerOTHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerOTHour"));
        table.setItems(exportCheckinDetails);
    }

    public void confirmExport() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save to CSV file !");
        String s = "Save to CSV file successfully !";
        alert.setContentText(s);
        alert.showAndWait();
    }
    public void exportWorker () throws IOException {
        ExportCheckinDetail.exportWorker();
        confirmExport();
    }
    public void switchtoExportUnitList (ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_LIST_UNIT_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditDataRequestsList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_REQUEST_LIST_VIEW_FXML));
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
}
