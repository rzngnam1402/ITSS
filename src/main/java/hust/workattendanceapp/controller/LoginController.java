package hust.workattendanceapp.controller;


import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.controller.officer.ManagerHomepageViewController;
import hust.workattendanceapp.controller.worker.WorkerHomepageViewController;
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
import java.util.ArrayList;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameInput;
    private final ArrayList<String> manager = new ArrayList<String>() {
        {
            add("20205004");
            add("20205025");
            add("20200377");
        }
    };
    private final ArrayList<String> worker = new ArrayList<String>() {
        {
            add("20205135");
            add("20205070");
        }
    };

    public void handleLogin(ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        if (manager.contains(username)) {
            switchToManager(event, username);
        } else if (worker.contains(username)) {
            switchToWorker(event, username);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something wrong !");
            String s = "Incorrect password or username. Please log in again !";
            alert.setContentText(s);
            alert.showAndWait();
        }
    }

    public void switchToWorker(ActionEvent event, String employeeID) {
        try {
            FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.WORKER_HOMEPAGE_VIEW_FXML));
            Parent root = (Parent) loader.load();
            WorkerHomepageViewController controller = loader.getController();
            controller.init(employeeID);

            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToManager(ActionEvent event, String employeeID) {
        try {
            FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
            Parent root = (Parent) loader.load();
            ManagerHomepageViewController controller = loader.getController();
            controller.init(employeeID);

            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
