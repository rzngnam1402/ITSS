package hust.workattendanceapp.model.employee;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class EmployeeInformation {
    public EmployeeInformation(String name, String id, String sex, String email,
                               String phone, String role, String unit, String img) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.unit = unit;
        this.img = img;
    }

    private String name;
    private String id;
    private String sex;
    private String email;
    private String phone;
    private String role;
    private String unit;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static ObservableList getEmployeeData() {
        ObservableList<EmployeeInformation> employeeList = null;
        Gson gson = new Gson();
        try {
            ArrayList<EmployeeInformation> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/EmployeeInformation.json");
            Type type = new TypeToken<ArrayList<EmployeeInformation>>() {
            }.getType();
            alist = gson.fromJson(reader, type);
            employeeList = FXCollections.observableArrayList(alist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void getEmployeeDetailByID(String id) {

    }
}
