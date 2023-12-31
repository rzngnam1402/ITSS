package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.model.worker.EditDataRequestForm;
import hust.workattendanceapp.subsystem.subsystemController.CRUDSystem;
import hust.workattendanceapp.validate.TimeFormatValidate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

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

    public void init(String employeeID) {
        employeeIDLabel.setText(WorkerHomepageViewController.employeeID);
    }

    public EditDataRequestForm createNewEditDataRequest(EditDataRequestForm detailData) {
        detailData.setRequestID(UUID.randomUUID().toString());
        employeeIDLabel.setText(WorkerHomepageViewController.employeeID);
        detailData.setEmployeeID(WorkerHomepageViewController.employeeID);
        detailData.setStatus("Pending");
        detailData.setDate(datePickerField.getValue().toString());
        detailData.setDescription(descriptionField.getText());
        detailData.setOldCheckinTime(oldCheckinTimeField.getText());
        detailData.setNewCheckinTime(newCheckinTimeField.getText());
        detailData.setOldCheckoutTime(oldCheckoutTimeField.getText());
        detailData.setNewCheckoutTime(newCheckoutTimeField.getText());
        return detailData;
    }

    public void confirmSendRequest(ActionEvent event) throws IOException {
        EditDataRequestForm editDataRequestForm = new EditDataRequestForm();
        editDataRequestForm = createNewEditDataRequest(editDataRequestForm);
        if (TimeFormatValidate.checkDataError(editDataRequestForm.getOldCheckinTime()) &&
                TimeFormatValidate.checkDataError(editDataRequestForm.getNewCheckinTime()) &&
                TimeFormatValidate.checkDataError(editDataRequestForm.getOldCheckoutTime()) &&
                TimeFormatValidate.checkDataError(editDataRequestForm.getNewCheckoutTime())) {

            System.out.println(editDataRequestForm);
            try {
                CRUDSystem.insertOne("src/main/java/hust/workattendanceapp/subsystem/data/EditDataRequestForm.json", editDataRequestForm);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Send Edit Data Request !");
            String s = "Send Edit Data Request Successfully";
            alert.setContentText(s);
            alert.showAndWait();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Time Input Error !");
            String s = "You have typed wrong time format. Please check again!\nFormat: hh:mm\nLimit 00:00 - 23:59";
            alert.setContentText(s);
            alert.showAndWait();
        }
    }

    public void cancelEdit(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
