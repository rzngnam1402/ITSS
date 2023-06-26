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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalAttendanceController {
    private Stage stage;
    private Scene scene;
    private Parent root;



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
            EditDataRequestFormPopUpController controller = loader.getController();
//            controller.createNewEditForm(selected);

            Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
