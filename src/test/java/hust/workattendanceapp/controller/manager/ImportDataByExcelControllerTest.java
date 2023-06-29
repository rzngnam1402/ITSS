package hust.workattendanceapp.controller.manager;

import hust.workattendanceapp.model.manager.DataToImport;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;

class ImportDataByExcelControllerTest {
    @BeforeEach
    void setup() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Thread t = new Thread(() -> {
            TestApplication.launch(TestApplication.class);
            latch.countDown();
        });
        t.setDaemon(true);
        t.start();
        latch.await();
    }

    @Test
    void tc1() {
        CheckBox result = new CheckBox();
        result.setSelected(false);
        CheckBox compare = new CheckBox();
        compare.setSelected(true);

        ObservableList<DataToImport> resultList = FXCollections.observableArrayList();
        resultList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", result));
        resultList.get(0).setSelect(result);

        ObservableList<DataToImport> comparedList = FXCollections.observableArrayList();
        comparedList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", compare));
        ImportDataByExcelController importData = new ImportDataByExcelController();
        comparedList = importData.setCheckBoxStatus(comparedList,false);
        assertEquals(resultList.get(0).getSelect().isSelected(), comparedList.get(0).getSelect().isSelected());
    }


    @Test
    void tc2() {
        CheckBox result = new CheckBox();
        result.setSelected(true);
        CheckBox compare = new CheckBox();
        compare.setSelected(false);

        ObservableList<DataToImport> resultList = FXCollections.observableArrayList();
        resultList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", result));
        resultList.get(0).setSelect(result);

        ObservableList<DataToImport> comparedList = FXCollections.observableArrayList();
        comparedList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", compare));
        ImportDataByExcelController importData = new ImportDataByExcelController();
        comparedList = importData.setCheckBoxStatus(comparedList,true);
        assertEquals(resultList.get(0).getSelect().isSelected(), comparedList.get(0).getSelect().isSelected());
    }

    @Test
    void tc3() {
        CheckBox result = new CheckBox();
        result.setSelected(true);
        CheckBox compare = new CheckBox();
        compare.setSelected(true);

        ObservableList<DataToImport> resultList = FXCollections.observableArrayList();
        resultList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", result));
        resultList.get(0).setSelect(result);

        ObservableList<DataToImport> comparedList = FXCollections.observableArrayList();
        comparedList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", compare));
        ImportDataByExcelController importData = new ImportDataByExcelController();
        comparedList = importData.setCheckBoxStatus(comparedList,true);
        assertEquals(resultList.get(0).getSelect().isSelected(), comparedList.get(0).getSelect().isSelected());
    }

    @Test
    void tc4() {
        CheckBox result = new CheckBox();
        result.setSelected(false);
        CheckBox compare = new CheckBox();
        compare.setSelected(false);

        ObservableList<DataToImport> resultList = FXCollections.observableArrayList();
        resultList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", result));
        resultList.get(0).setSelect(result);

        ObservableList<DataToImport> comparedList = FXCollections.observableArrayList();
        comparedList.add(new DataToImport("20205004", "Le Giang Nam",
                "28-06-2023", "8:28", "17:45", compare));
        ImportDataByExcelController importData = new ImportDataByExcelController();
        comparedList = importData.setCheckBoxStatus(comparedList,false);
        assertEquals(resultList.get(0).getSelect().isSelected(), comparedList.get(0).getSelect().isSelected());
    }

    // Inner class to initialize JavaFX toolkit
    public static class TestApplication extends Application {
        @Override
        public void start(javafx.stage.Stage stage) {
            // No need to show any UI
            Platform.exit();
        }
    }
}
