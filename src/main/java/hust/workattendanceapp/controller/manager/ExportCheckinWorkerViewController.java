package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.worker.ExportCheckinWorker;
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
import java.util.ResourceBundle;


public class ExportCheckinWorkerViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<ExportCheckinWorker> table;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> unitNumberDetail;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> workerSTTColumn;
    @FXML
    private TableColumn<ExportCheckinWorker, String> workerNameColumn;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> workerNumberColumn;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> workerMonthColumn;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> workerWorkHourColumn;
    @FXML
    private TableColumn<ExportCheckinWorker, Integer> workerOTHourColumn;
    @FXML
    ObservableList<ExportCheckinWorker> checkinDetails;
    ObservableList<ExportCheckinWorker> exportCheckinWorkers = FXCollections.observableArrayList();
    @FXML
    private TextField monthField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void createNewDetailWorker() {
        checkinDetails = ExportCheckinWorker.getCheckinDetail();
        workerSTTColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, Integer>("workerSTT"));
        workerNameColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, String>("workerName"));
        workerNumberColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, Integer>("workerNumber"));
        workerMonthColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, Integer>("workerMonth"));
        workerWorkHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, Integer>("workerWorkHour"));
        workerOTHourColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinWorker, Integer>("workerOTHour"));
        table.setItems(checkinDetails);

    }
    public boolean checkMonthString (String month) {
        if (month.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) {
            return true;
        }
        else {
            return false;
        }
    }

    public void monthFilter(ActionEvent event) throws IOException {
        String month = monthField.getText();
        if (month.equals("")) {
            table.setItems(checkinDetails);
        } else if (checkMonthString(month)) {
            exportCheckinWorkers.removeAll(exportCheckinWorkers);
            for (ExportCheckinWorker eachstring : checkinDetails) {
                if (eachstring.getWorkerMonth() == Integer.parseInt(month)) {
                    exportCheckinWorkers.add(new ExportCheckinWorker(eachstring.getWorkerSTT(), eachstring.getWorkerName(), eachstring.getWorkerNumber(), eachstring.getWorkerMonth(), eachstring.getWorkerWorkHour(), eachstring.getWorkerOTHour()));
                }
            }
            table.setItems(exportCheckinWorkers);
        } else alertFilterError();
    }

    public void alertFilterError() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error Input");
        String s = "Month should be an Integer between 1 and 12!";
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
        if (exportCheckinWorkers.isEmpty()) ExportCheckinWorker.exportWorker(checkinDetails);
        else ExportCheckinWorker.exportWorker(exportCheckinWorkers);
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
