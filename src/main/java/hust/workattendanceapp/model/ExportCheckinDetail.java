package hust.workattendanceapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportCheckinDetail {
    public ExportCheckinDetail(int unitNumberDetail, int workerSTT, String workerName, int workerNumber, int workerMonth, int workerWorkHour, int workerOTHour) {
        this.unitNumberDetail = unitNumberDetail;
        this.workerSTT = workerSTT;
        this.workerName = workerName;
        this.workerNumber = workerNumber;
        this.workerMonth = workerMonth;
        this.workerWorkHour = workerWorkHour;
        this.workerOTHour = workerOTHour;
    }

    private int unitNumberDetail;
    private int workerSTT;
    private String workerName;
    private int workerNumber;
    private int workerMonth;
    private int workerWorkHour;
    private int workerOTHour;

    public int getUnitNumberDetail() {
        return unitNumberDetail;
    }
    public void setUnitNumberDetail(int unitNumberDetail) {
        this.unitNumberDetail = unitNumberDetail;
    }
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
        ObservableList<ExportCheckinDetail> exportCheckinDetails = FXCollections.observableArrayList();
        exportCheckinDetails.add(new ExportCheckinDetail(1, 1,
                "Do Chi Thanh", 1254, 6, 50, 50));
        exportCheckinDetails.add(new ExportCheckinDetail(1, 2,
                "Do Chi Thanh", 1254, 6, 50, 50));
        exportCheckinDetails.add(new ExportCheckinDetail(1, 3,
                "Do Chi Thanh", 1254, 6, 50, 50));
        exportCheckinDetails.add(new ExportCheckinDetail(1, 4,
                "Do Chi Thanh", 1254, 6, 50, 50));
        exportCheckinDetails.add(new ExportCheckinDetail(2, 5,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(2, 6,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(2, 7,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(3, 8,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(3, 9,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(3, 10,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(4, 11,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(4, 12,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 13,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 14,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 15,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 16,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 17,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 18,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 19,
                "Do Chi Thanh", 1254, 6, 50, 510));
        exportCheckinDetails.add(new ExportCheckinDetail(5, 20,
                "Do Chi Thanh", 1254, 6, 50, 510));
        return exportCheckinDetails;
    }
    public static void exportWorker() throws IOException {
        List<ExportCheckinDetail> list = getCheckinDetail();

        StringBuilder str = new StringBuilder("");

        str.append("STT").append(";");
        str.append("Worker Name").append(";");
        str.append("Worker Number").append(";");
        str.append("Month").append(";");
        str.append("Work Hour").append(";");
        str.append("OT Hour");
        str.append("\n");

        for (ExportCheckinDetail eachstring : list) {
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/hust/workattendanceapp/csvdata/checkinWorker.csv"));
        writer.write(commaseparatedlist);

        writer.close();
    }
}
