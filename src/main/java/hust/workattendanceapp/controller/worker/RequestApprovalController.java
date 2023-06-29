package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.subsystem.subsystemController.CRUDSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestApprovalController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label employIDLabel;
    @FXML
    private TableView<Object> table;
    @FXML
    private TableColumn<Object, String> requestIDColumn;
    @FXML
    private TableColumn<Object, String> statusColumn;
    @FXML
    private TableColumn<Object, String> dateColumn;
    @FXML
    private TableColumn<Object, String> oldCheckInTimeColumn;
    @FXML
    private TableColumn<Object, String> newCheckInTimeColumn;
    @FXML
    private TableColumn<Object, String> oldCheckOutTimeColumn;
    @FXML
    private TableColumn<Object, String> newCheckOutTimeColumn;
    @FXML
    private TableColumn<Object, String> descriptionColumn;

    ObservableList<Object> requestList;

    public void init(String employeeID) {
        employIDLabel.setText("Employee ID: " + WorkerHomepageViewController.employeeID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        requestList = FXCollections.observableArrayList(CRUDSystem.getData("src/main/java/hust/workattendanceapp/subsystem/data/EditDataRequestForm.json",WorkerHomepageViewController.employeeID));
        requestIDColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("requestID"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("status"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("date"));
        oldCheckInTimeColumn.setCellValueFactory((new PropertyValueFactory<Object, String>("oldCheckinTime")));
        newCheckInTimeColumn.setCellValueFactory((new PropertyValueFactory<Object, String>("newCheckinTime")));
        oldCheckOutTimeColumn.setCellValueFactory((new PropertyValueFactory<Object, String>("oldCheckoutTime")));
        newCheckOutTimeColumn.setCellValueFactory((new PropertyValueFactory<Object, String>("newCheckoutTime")));
        descriptionColumn.setCellValueFactory((new PropertyValueFactory<Object, String>("description")));
        table.setItems(requestList);
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.WORKER_HOMEPAGE_VIEW_FXML));
        Parent root = (Parent) loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        WorkerHomepageViewController controller = loader.getController();
        controller.init(WorkerHomepageViewController.employeeID);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPersonalAttendance(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.PERSONAL_ATTENDANCE));
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
