package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkerHomepageViewController {
    public static String employeeID;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label employeeIDLabel;
    public void init(String employeeID) {
        WorkerHomepageViewController.employeeID = employeeID;
        employeeIDLabel.setText(WorkerHomepageViewController.employeeID);
    }

    public Label getEmployeeIDLabel() {
        return employeeIDLabel;
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
