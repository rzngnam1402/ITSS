package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.ExportCheckinOfficer;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExportCheckinOfficerViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<ExportCheckinOfficer> table;
    @FXML
    private TableColumn<ExportCheckinOfficer, Integer> officerSTTColumn;
    @FXML
    private TableColumn<ExportCheckinOfficer, String> officerNameColumn;
    @FXML
    private TableColumn<ExportCheckinOfficer, Integer> officerNumberColumn;
    @FXML
    private TableColumn<ExportCheckinOfficer, Integer> officerMonthColumn;
    @FXML
    private TableColumn<ExportCheckinOfficer, Integer> officerWorkShiftColumn;
    @FXML
    private TableColumn<ExportCheckinOfficer, Integer> officerUncompletedShiftColumn;
    @FXML
    ObservableList<ExportCheckinOfficer> checkinDetails;
    ObservableList<ExportCheckinOfficer> exportCheckinOfficers = FXCollections.observableArrayList();
    @FXML
    private TextField monthField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void createNewDetailOfficer() {
        checkinDetails = ExportCheckinOfficer.getCheckinDetail();
        officerSTTColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, Integer>("officerSTT"));
        officerNameColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, String>("officerName"));
        officerNumberColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, Integer>("officerNumber"));
        officerMonthColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, Integer>("officerMonth"));
        officerWorkShiftColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, Integer>("officerWorkShift"));
        officerUncompletedShiftColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinOfficer, Integer>("officerUncompletedShift"));
        table.setItems(checkinDetails);
    }

    public void monthFilter(ActionEvent event) throws IOException {
        String month = monthField.getText();
        if (month.equals("")) {
            table.setItems(checkinDetails);
        } else if (Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) {
            exportCheckinOfficers.removeAll(exportCheckinOfficers);
            for (ExportCheckinOfficer eachstring : checkinDetails) {
                if (eachstring.getOfficerMonth() == Integer.parseInt(month)) {
                    exportCheckinOfficers.add(new ExportCheckinOfficer(eachstring.getOfficerSTT(), eachstring.getOfficerName(), eachstring.getOfficerNumber(), eachstring.getOfficerMonth(), eachstring.getOfficerWorkShift(), eachstring.getOfficerUncompletedShift()));
                }
            }
            table.setItems(exportCheckinOfficers);
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

    public void exportOfficer() throws IOException {
        if (exportCheckinOfficers.isEmpty()) ExportCheckinOfficer.exportOfficer(checkinDetails);
        else ExportCheckinOfficer.exportOfficer(exportCheckinOfficers);
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