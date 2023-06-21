module hust.workattendanceapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens hust.workattendanceapp to javafx.fxml;
    exports hust.workattendanceapp;
    exports hust.workattendanceapp.controller;
    opens hust.workattendanceapp.controller to javafx.fxml;
}