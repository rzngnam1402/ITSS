package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.manager.ExportCheckinUnitList;
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

public class ExportCheckinUnitListViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<ExportCheckinUnitList> table;
    @FXML
    private TableColumn<ExportCheckinUnitList, Integer> sTTColumn;
    @FXML
    private TableColumn<ExportCheckinUnitList, String> unitNameColumn;
    @FXML
    private TableColumn<ExportCheckinUnitList, Integer> numOfEmployeesColumn;
    @FXML
    private TableColumn<ExportCheckinUnitList, String> unitManagerColumn;
    @FXML
    ObservableList<ExportCheckinUnitList> unitList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitList = ExportCheckinUnitList.getUnitList();
        sTTColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinUnitList, Integer>("sTT"));
        unitNameColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinUnitList, String>("unitName"));
        numOfEmployeesColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinUnitList, Integer>("numOfEmployees"));
        unitManagerColumn.setCellValueFactory(new PropertyValueFactory<ExportCheckinUnitList, String>("unitManager"));
        table.setItems(unitList);
    }
    public void handleChooseUnit (ActionEvent event) throws Exception {
        ExportCheckinUnitList selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Choose unit error!");
            String s = "Please choose one unit !";
            alert.setContentText(s);
            alert.showAndWait();
        } else if (selected.getSTT() == 1) {
            switchToWorkerDetail(event);
        } else if (selected.getSTT() == 2) {
            switchToOfficerDetail(event);
        }
    }

    private void switchToOfficerDetail(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_OFFICER_VIEW));
            Parent root = (Parent) loader.load();
            ExportCheckinOfficerViewController controller = loader.getController();
            controller.createNewDetailOfficer();
            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToWorkerDetail (ActionEvent event) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_WORKER_VIEW));
            Parent root = (Parent) loader.load();
            ExportCheckinWorkerViewController controller = loader.getController();
            controller.createNewDetailWorker();
            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
