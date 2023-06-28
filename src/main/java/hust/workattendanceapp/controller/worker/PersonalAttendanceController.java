package hust.workattendanceapp.controller.worker;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.controller.manager.EditCheckinDetailDataFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class PersonalAttendanceController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label myLabel;

    @FXML
    private DatePicker myDatePickerFrom;

    public void getFromDate(ActionEvent event) {
        LocalDate myDate = myDatePickerFrom.getValue();
        //myLabel.setText(myDate.toString());
    }

    @FXML
    private DatePicker myDatePickerTo;

    public void getToDate(ActionEvent event) {
        LocalDate myDate = myDatePickerTo.getValue();
        //myLabel.setText(myDate.toString());
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
    public void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.LOGIN_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void editDataRequestFormPopUp(ActionEvent event) throws  IOException{
        try {
            FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_DATA_REQUEST_FORM_POP_UP));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            EditDataRequestFormPopUpController controller = loader.getController();
            controller.init(WorkerHomepageViewController.employeeID);
            stage = new Stage();

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void switchToRequestApproval(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.REQUEST_APPROVAL_VIEW));
        Parent root = (Parent) loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        RequestApprovalController controller = loader.getController();
        controller.init(WorkerHomepageViewController.employeeID);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
