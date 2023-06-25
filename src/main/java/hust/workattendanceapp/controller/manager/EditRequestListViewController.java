package hust.workattendanceapp.controller.manager;


import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.EditDataRequest;
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


public class EditRequestListViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<EditDataRequest> table;
    @FXML
    private TableColumn<EditDataRequest, Integer> requestIDColumn;
    @FXML
    private TableColumn<EditDataRequest, String> employeeNameColumn;
    @FXML
    private TableColumn<EditDataRequest, String> employeeIDColumn;
    @FXML
    private TableColumn<EditDataRequest, String> statusColumn;
    @FXML
    private TableColumn<EditDataRequest, String> dateColumn;
    ObservableList<EditDataRequest> requestList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        requestList = EditDataRequest.getEditRequestList();
        requestIDColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, Integer>("requestID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("employeeName"));
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("employeeID"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("status"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("date"));
        table.setItems(requestList);
    }

    public void deleteEditDataRequest(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Data!");
        String s = "Do you want to delete?";
        alert.setContentText(s);
        alert.showAndWait();
        EditDataRequest selected = table.getSelectionModel().getSelectedItem();
        requestList.remove(selected);
    }

    public void rejectEditDataRequest(ActionEvent e) {
        EditDataRequest selected = table.getSelectionModel().getSelectedItem();
        requestList.get(selected.getRequestID() - 1).setStatus("rejected");
        table.refresh();
    }

    public void approveEditDataRequest(ActionEvent e) {
        EditDataRequest selected = table.getSelectionModel().getSelectedItem();
        requestList.get(selected.getRequestID() - 1).setStatus("approved");
        table.refresh();
    }

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

    public void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.LOGIN_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
