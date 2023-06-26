package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.WorkAttendanceApplication;
import hust.workattendanceapp.constraints.FXMLConstraints;
import hust.workattendanceapp.model.DataToImport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImportDataByExcelController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<DataToImport> table;
    @FXML
    private TableColumn<DataToImport, String> IDColumn;
    @FXML
    private TableColumn<DataToImport, String> NameColumn;
    @FXML
    private TableColumn<DataToImport, String> CheckinColumn;
    @FXML
    private TableColumn<DataToImport, String> CheckoutColumn;
    @FXML
    private TableColumn<DataToImport, CheckBox> SelectColumn;
    ObservableList<DataToImport> ImportList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ImportList= DataToImport.getImportList();
        IDColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("ID"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("Name"));
        CheckinColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("Checkin"));
        CheckoutColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, String>("Checkout"));
        SelectColumn.setCellValueFactory(new PropertyValueFactory<DataToImport, CheckBox>("Select"));
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
