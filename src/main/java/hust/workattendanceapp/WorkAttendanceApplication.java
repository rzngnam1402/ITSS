package hust.workattendanceapp;

import hust.workattendanceapp.constraints.FXMLConstraints;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkAttendanceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WorkAttendanceApplication.class.getResource(FXMLConstraints.IMPORT_DATA_BY_EXCEL_VIEW_FXML));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("WorkAttendanceApplication!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}