module hust.workattendanceapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;

    opens hust.workattendanceapp to javafx.fxml;
    exports hust.workattendanceapp;
    exports hust.workattendanceapp.controller;
    opens hust.workattendanceapp.controller to javafx.fxml;
    exports hust.workattendanceapp.controller.worker;
    opens hust.workattendanceapp.controller.worker to javafx.fxml;
    exports hust.workattendanceapp.controller.officer;
    opens hust.workattendanceapp.controller.officer to javafx.fxml;
    opens hust.workattendanceapp.model to javafx.base, com.google.gson;
    exports hust.workattendanceapp.model;
    exports hust.workattendanceapp.controller.manager;
    opens hust.workattendanceapp.controller.manager to javafx.fxml;
}