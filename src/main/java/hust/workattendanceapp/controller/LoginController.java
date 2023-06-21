package hust.workattendanceapp.controller;


import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameInput;

    public void switchToWorkerHomepage(ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        if (username.equals("worker")) {
            root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.WORKER_HOMEPAGE_VIEW_FXML));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something wrong !");
            String s = "Incorrect password or username. Please log in again !";
            alert.setContentText(s);
            alert.showAndWait();
        }
    }
}
