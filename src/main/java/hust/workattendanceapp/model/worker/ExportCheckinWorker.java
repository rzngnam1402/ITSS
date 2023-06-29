package hust.workattendanceapp.model.worker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExportCheckinWorker {
    public ExportCheckinWorker(int workerSTT, String workerName, int workerNumber, int workerMonth, int workerWorkHour, int workerOTHour) {
        this.workerSTT = workerSTT;
        this.workerName = workerName;
        this.workerNumber = workerNumber;
        this.workerMonth = workerMonth;
        this.workerWorkHour = workerWorkHour;
        this.workerOTHour = workerOTHour;
    }

    private int workerSTT;
    private String workerName;
    private int workerNumber;
    private int workerMonth;
    private int workerWorkHour;
    private int workerOTHour;
    public int getWorkerSTT() {
        return workerSTT;
    }
    public void setWorkerSTT(int workerSTT) {
        this.workerSTT = workerSTT;
    }
    public String getWorkerName() {
        return workerName;
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
    public int getWorkerNumber() {
        return workerNumber;
    }
    public void setWorkerNumber(int workerNumber) {
        this.workerNumber = workerNumber;
    }
    public int getWorkerMonth() {
        return workerMonth;
    }
    public void setWorkerMonth(int workerMonth) {
        this.workerMonth = workerMonth;
    }
    public int getWorkerWorkHour() {
        return workerWorkHour;
    }
    public void setWorkerWorkHour(int workerWorkHour) {
        this.workerWorkHour = workerWorkHour;
    }
    public int getWorkerOTHour() {
        return workerOTHour;
    }
    public void setWorkerOTHour(int workerOTHour) {
        this.workerOTHour = workerOTHour;
    }
    public static ObservableList getCheckinDetail() {
        ObservableList<ExportCheckinWorker> exportCheckinWorkers = FXCollections.observableArrayList();
        Gson gson = new Gson();
        try {
            ArrayList<ExportCheckinWorker> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/WorkerDetail.json");
            Type type = new TypeToken<ArrayList<ExportCheckinWorker>>() {
            }.getType();
            alist = gson.fromJson(reader, type);
            exportCheckinWorkers = FXCollections.observableArrayList(alist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportCheckinWorkers;
    }
    public static void exportWorker(ObservableList exportCheckinDetail) throws IOException {
        List<ExportCheckinWorker> list = exportCheckinDetail;

        StringBuilder str = new StringBuilder("");

        str.append("STT").append(";");
        str.append("Worker Name").append(";");
        str.append("Worker Number").append(";");
        str.append("Month").append(";");
        str.append("Work Hour").append(";");
        str.append("OT Hour");
        str.append("\n");

        for (ExportCheckinWorker eachstring : list) {
            str.append(eachstring.getWorkerSTT()).append(";");
            str.append(eachstring.getWorkerName()).append(";");
            str.append(eachstring.getWorkerNumber()).append(";");
            str.append(eachstring.getWorkerMonth()).append(";");
            str.append(eachstring.getWorkerWorkHour()).append(";");
            str.append(eachstring.getWorkerOTHour());
            str.append("\n");
        }

        String commaseparatedlist = str.toString();

        if (commaseparatedlist.length() > 0)

            commaseparatedlist
                    = commaseparatedlist.substring(
                    0, commaseparatedlist.length() - 1);

        System.out.println(commaseparatedlist);
        try{
            whenWriteStringUsingBufferedWritter_thenCorrect(commaseparatedlist);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void whenWriteStringUsingBufferedWritter_thenCorrect(String commaseparatedlist)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/hust/workattendanceapp/data/csvdata/checkinWorker.csv"));
        writer.write(commaseparatedlist);

        writer.close();
    }
}
