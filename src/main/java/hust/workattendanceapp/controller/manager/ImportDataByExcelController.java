package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.manager.DataToImport;
import hust.workattendanceapp.model.manager.ImportedInstance;
import hust.workattendanceapp.subsystem.subsystemController.CRUDSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ImportDataByExcelController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<DataToImport> table;
    @FXML
    private TableColumn<DataToImport, String> employeeIDColumn;
    @FXML
    private TableColumn<DataToImport, String> employeeNameColumn;
    @FXML
    private TableColumn<DataToImport, Date> dateColumn;
    @FXML
    private TableColumn<DataToImport, String> checkinTimeColumn;
    @FXML
    private TableColumn<DataToImport, String> checkoutTimeColumn;
    @FXML
    private TableColumn<DataToImport, CheckBox> selectColumn;
    ObservableList<DataToImport> ImportList;
    @FXML
    Button selectButton;
    @FXML
    CheckBox selectAllCheckBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("employeeID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("employeeName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, Date>("date"));
        checkinTimeColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("checkinTime"));
        checkoutTimeColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("checkoutTime"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, CheckBox>("select"));
        table.setItems(ImportList);
//        selectAllCheckBox.setSelected(false);
        selectAllCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                ObservableList<DataToImport> recordList = table.getItems();

                if (selectAllCheckBox.isSelected()) {
                    recordList = setCheckBoxStatus(recordList, true);
                } else recordList = setCheckBoxStatus(recordList, false);


                table.setItems(recordList);
                table.refresh();
            }
        });
    }

    @FXML
    public void chooseFile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV file", "*.csv"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                ImportList = DataToImport.getImportList(file.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        table.setItems(ImportList);
    }

    @FXML
    public void importToJson(ActionEvent event) throws IOException {
        ObservableList<DataToImport> recordList = table.getItems();
        String ifSuccess = "Inserted to json";
        for (DataToImport record : recordList) {
            if (record.getSelect().isSelected()) {
                ImportedInstance new_record = new ImportedInstance(record.getEmployeeID(), record.getEmployeeName(), record.getDate(), record.getCheckinTime(), record.getCheckoutTime());
                ifSuccess = CRUDSystem.insertOne("src/main/java/hust/workattendanceapp/subsystem/data/excelmportedData.json", new_record);
                if (ifSuccess != "Inserted to json") {
                    alertUnsuccessful();
                    break;
                }
            }
        }
        if (ifSuccess == "Inserted to json") {
            alertSuccessful();
        }

    }


    private void alertSuccessful() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful");
        String s = "You have successful imported data !";
        alert.setContentText(s);
        alert.showAndWait();
    }

    private void alertUnsuccessful() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Unsuccessful");
        String s = "Failed!";
        alert.setContentText(s);
        alert.showAndWait();
    }

    public ObservableList<DataToImport> setCheckBoxStatus(ObservableList<DataToImport> recordList, boolean status) {
        for (DataToImport record : recordList) {
            CheckBox a = new CheckBox();
            a.setSelected(status);
            record.setSelect(a);
        }
        return recordList;
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
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

    public void switchToEditDataRequestsList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.EDIT_REQUEST_LIST_VIEW_FXML));
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

    public void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.LOGIN_VIEW_FXML));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
