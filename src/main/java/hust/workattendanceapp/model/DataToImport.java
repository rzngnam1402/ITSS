package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

public class DataToImport {
    public DataToImport(String ID, String Name, String Checkin, String Checkout, CheckBox select) {
        this.ID = ID;
        this.Name = Name;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.select = new CheckBox();
    }

    private String ID;
    private String Name;
    private String Checkin;
    private String Checkout;
    private CheckBox select;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String employeeSex) {
        this.Checkin = Checkin;
    }

    public String getCheckout() {
        return Checkout;
    }

    public void setCheckout(String Checkout) {
        this.Checkout = Checkout;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox Checkout) {
        this.select = select;
    }


    public static ObservableList getImportList() {
        ObservableList<DataToImport> ImportList = FXCollections.observableArrayList();
        // get data from json file
        ImportList.add(new DataToImport("1223", "Le Giang Nam",
                "20205004", "male",null));
        return ImportList;

    }

}
