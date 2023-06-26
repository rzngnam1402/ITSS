package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.controller.LoginController;
import hust.workattendanceapp.model.EditDataRequestForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class EditDataRequestFormPopUpController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label employeeIDLabel;
    @FXML
    private DatePicker datePickerField;
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

    public void createNewEditDataRequest(EditDataRequestForm detailData){
//        employeeIDLabel.setText();
    }
    public void confirmSendRequest(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Send Edit Data Request !");
        String s = "Send Edit Data Request Successfully";
        alert.setContentText(s);
        alert.showAndWait();
        switchToPersonalAttendance(event);
    }
    public void cancelEdit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.PERSONAL_ATTENDANCE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
}
