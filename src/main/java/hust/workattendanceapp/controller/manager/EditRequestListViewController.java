package hust.workattendanceapp.controller.manager;


import hust.workattendanceapp.model.EditDataRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class EditRequestListViewController implements Initializable {
    @FXML
    private TableView<EditDataRequest> table;
    @FXML
    private TableColumn<EditDataRequest, Integer> requestIDColumn;
    @FXML
    private TableColumn<EditDataRequest, String> employeeNameColumn;
    @FXML
    private TableColumn<EditDataRequest, String> employeeIDColumn;
    @FXML
    private TableColumn<EditDataRequest, String> statusColumn;
    @FXML
    private TableColumn<EditDataRequest, String> dateColumn;
    ObservableList<EditDataRequest> requestList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        requestList = EditDataRequest.getEditRequestList();
        requestIDColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, Integer>("requestID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("employeeName"));
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("employeeID"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("status"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<EditDataRequest, String>("date"));
        table.setItems(requestList);
    }

    public void deleteEditDataRequest(ActionEvent e) {
        EditDataRequest selected = table.getSelectionModel().getSelectedItem();
        requestList.remove(selected);
    }
}
