package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.EditDataRequest;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class EditCheckinDetailDataFormController implements Initializable {
    public EditCheckinDetailDataFormController() {

    }

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label nameLabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField oldCheckinTimeField;
    @FXML
    private TextField newCheckinTimeField;

    @FXML
    private TextField oldCheckoutTimeField;
    @FXML
    private TextField newCheckoutTimeField;

    ObservableList<EditDataRequest> requestList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        nameLabel.setText("name");
    }

    public void createNewEditForm(EditDataRequest detailData) {
        String name = detailData.getEmployeeName();
        String id = detailData.getEmployeeID();
        String description = detailData.getDescription();
        String status = detailData.getStatus();
        String date = detailData.getDate();
        String oldCheckoutTime = detailData.getOldCheckoutTime();
        String newCheckoutTime = detailData.getNewCheckoutTime();
        String oldCheckinTime = detailData.getOldCheckinTime();
        String newCheckinTime = detailData.getNewCheckinTime();
        nameLabel.setText(name);
        IDLabel.setText(id);
        statusLabel.setText(status);
        dateLabel.setText(date);
        descriptionField.setText(description);
        newCheckinTimeField.setText(newCheckinTime);
        oldCheckinTimeField.setText(oldCheckinTime);
        newCheckoutTimeField.setText(newCheckoutTime);
        oldCheckoutTimeField.setText(oldCheckoutTime);
    }

    public void checkDataError(ActionEvent event) {
        checkTimeField(newCheckinTimeField.getText());
        checkTimeField(newCheckoutTimeField.getText());
    }

    public void checkTimeField(String timeToCheck) {
        System.out.println(timeToCheck);
        try {
            LocalTime.parse(timeToCheck);
            System.out.println("Valid time string: " + timeToCheck);
        } catch (DateTimeParseException | NullPointerException e) {
            System.out.println("Invalid time string: " + timeToCheck);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Time Input Error !");
            String s = "You have typed wrong time format. Please check again!";
            alert.setContentText(s);
            alert.showAndWait();
        }
    }

    public void confirmEdit(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save to Checkin log !");
        String s = "Save to checkin log successfully !";
        alert.setContentText(s);
        alert.showAndWait();
        switchToEditRequestListView(event);
    }

    public void switchToEditRequestListView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_REQUEST_LIST_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void cancelEdit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_REQUEST_LIST_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
