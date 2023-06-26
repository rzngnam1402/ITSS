package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        ObservableList<EmployeeInformation> employeeList = FXCollections.observableArrayList();
        employeeList.add(new EmployeeInformation("Le Giang Nam", "20205004",
                "male", "nam.lg205004@sis.hust.edu.vn", "0966244758",
                "Manager", "Officer","src/main/resources/hust/workattendanceapp/styles/nam.jpg"));
        employeeList.add(new EmployeeInformation("Do Chi Thanh", "20205025",
                "male", "thanh.dc205025@sis.hust.edu.vn", "0987123456",
                "Manager", "Officer", "src/main/resources/hust/workattendanceapp/styles/thanh.jpg"));
        employeeList.add(new EmployeeInformation("Do Khanh Ly", "20200377",
                "female", "ly.dk200377@sis.hust.edu.vn", "0988666777",
                "Manager", "Officer","src/main/resources/hust/workattendanceapp/styles/ly.jpg"));
        employeeList.add(new EmployeeInformation("Bui Minh Dung", "20205070",
                "male", "dung.bm205070@sis.hust.edu.vn", "0987123456",
                "Worker", "Worker","src/main/resources/hust/workattendanceapp/styles/dung.jpg"));
        employeeList.add(new EmployeeInformation("Nguyen Ngoc Tu", "20205135",
                "female", "tu.nn205135@sis.hust.edu.vn", "0987123456",
                "Worker", "Worker","src/main/resources/hust/workattendanceapp/styles/tu.jpg"));
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
