package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataToImport {
    public DataToImport(String employeeID, String employeeName, Date date, String checkinTime, String checkoutTime, CheckBox select) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.date = date;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;

    }

    private String employeeID;
    private String employeeName;
    private Date date;
    private String checkinTime;
    private String checkoutTime;
    private CheckBox select;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String employeeSex) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox Checkout) {
        this.select = select;
    }

//    public static ObservableList getImportList() throws IOException{
//        ObservableList<DataToImport> ImportList = FXCollections.observableArrayList();
////                ImportList.add(new DataToImport("1223", "Le Giang Nam",
////                "20205004", "male",null));
//        return ImportList;
//    }
    public static ObservableList getImportList(String path) throws IOException {
        ObservableList<DataToImport> ImportList = FXCollections.observableArrayList();
//         get data from json file
//        ImportList.add(new DataToImport("1223", "Le Giang Nam",
//                "20205004", "male",null));

        BufferedReader reader = null;
        String line ="";
        System.out.println(path);

        try{
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date toDate = dateFormat.parse(row[2]);
                    ImportList.add(new DataToImport(row[0],row[1],toDate, row[3],row[4],null ));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
//            reader.close();
        }
        return ImportList;
    }

}
