package hust.workattendanceapp.controller.officer;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.employee.EmployeeInformation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class ManagerHomepageViewController{
    private Scene scene;
    private Parent root;
    private Stage stage;
    @FXML
    private Label employeeIDLabel;
    @FXML
    private Label employeeNameLabel;
    @FXML
    private Label employeeEmailLabel;
    @FXML
    private Label employeePhoneLabel;
    @FXML
    private Label employeeRoleLabel;
    @FXML
    private Label employeeUnitLabel;
    @FXML
    private ImageView employeeImage;
    private String employeeID;
    ObservableList<EmployeeInformation> employeeList;

    public void init(String employeeID) throws FileNotFoundException {
        this.employeeID = employeeID;
        employeeIDLabel.setText(employeeID);
        EmployeeInformation employee = getEmployeeData(employeeID);
        employeeNameLabel.setText(employee.getName());
        employeeEmailLabel.setText(employee.getEmail());
        employeePhoneLabel.setText(employee.getPhone());
        employeeRoleLabel.setText(employee.getRole());
        employeeUnitLabel.setText(employee.getUnit());
        InputStream stream = new FileInputStream(employee.getImg());
        Image image = new Image(stream);
        employeeImage.setImage(image);
        employeeImage.fitHeightProperty();
        employeeImage.fitWidthProperty();
    }

    public EmployeeInformation getEmployeeData(String employeeID) {
        employeeList = EmployeeInformation.getEmployeeData();
        for (EmployeeInformation p : employeeList) {
            if (Objects.equals(p.getId(), employeeID)) {
                return p;
            }
        }
        return null;
    }

    public void switchToEditDataRequestsList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_REQUEST_LIST_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOverallAttendance(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.OFFICER_OVERALL_ATTENDANCE_VIEW1_FXML));
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

    public void switchToExportCheckinListUnit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EXPORT_CHECKIN_LIST_UNIT_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToImportDataView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.IMPORT_DATA_BY_EXCEL_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}