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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ExportCheckinDetailViewController implements Initializable {
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
    ObservableList<ExportCheckinDetail> exportCheckinDetails = FXCollections.observableArrayList();
    @FXML
    private TextField monthField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void createNewDetailWorker() {
        checkinDetails = ExportCheckinDetail.getCheckinDetail();
        workerSTTColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerSTT"));
        workerNameColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, String>("workerName"));
        workerNumberColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerNumber"));
        workerMonthColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerMonth"));
        workerWorkHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerWorkHour"));
        workerOTHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinDetail, Integer>("workerOTHour"));
        table.setItems(checkinDetails);
    }

    public void monthFilter(ActionEvent event) throws IOException {
        String month = monthField.getText();
        if (month.equals("")) {
            table.setItems(checkinDetails);
        } else if (Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) {
            exportCheckinDetails.removeAll(exportCheckinDetails);
            for (ExportCheckinDetail eachstring : checkinDetails) {
                if (eachstring.getWorkerMonth() == Integer.parseInt(month)) {
                    exportCheckinDetails.add(new ExportCheckinDetail(eachstring.getWorkerSTT(), eachstring.getWorkerName(), eachstring.getWorkerNumber(), eachstring.getWorkerMonth(), eachstring.getWorkerWorkHour(), eachstring.getWorkerOTHour()));
                }
            }
            table.setItems(exportCheckinDetails);
        } else alertFilterError();

    }

    public void alertFilterError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error Input");
        String s = "Month should be between 1 and 12 !";
        alert.setContentText(s);
        alert.showAndWait();
    }

    public void confirmExport() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save to CSV file !");
        String s = "Save to CSV file successfully !";
        alert.setContentText(s);
        alert.showAndWait();
    }

    public void exportWorker() throws IOException {
        ExportCheckinDetail.exportWorker(exportCheckinDetails);
        confirmExport();
    }

    public void switchtoExportUnitList(ActionEvent event) throws IOException {
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
