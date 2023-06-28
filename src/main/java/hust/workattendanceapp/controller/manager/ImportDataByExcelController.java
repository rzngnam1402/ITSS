package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.DataToImport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

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
//    Label choosefilenoti;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            ImportList= DataToImport.getImportList();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("employeeID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("employeeName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<DataToImport,Date>("date"));
        checkinTimeColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("checkinTime"));
        checkoutTimeColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("checkoutTime"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, CheckBox>("select"));
        table.setItems(ImportList);
    }
    @FXML
    public void chooseFile(ActionEvent event) throws  IOException{
        System.out.println("Hello");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("D:\\20222\\ITSS\\src\\main\\java\\hust\\workattendanceapp\\model"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV file", "*.csv"));
        File file = fileChooser.showOpenDialog(null);
//        System.out.println(file.getAbsolutePath());
        if (file != null){
//            System.out.println(file.getAbsolutePath());
            try {
//                System.out.println(file.getAbsolutePath());
                ImportList= DataToImport.getImportList(file.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        table.setItems(ImportList);
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(WorkAttendanceApplication.class.getResource(FXMLConstraints.MANAGER_HOMEPAGE_VIEW_FXML));
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
