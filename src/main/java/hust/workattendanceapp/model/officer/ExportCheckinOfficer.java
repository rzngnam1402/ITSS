package hust.workattendanceapp.model.officer;

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
public class ExportCheckinOfficer {
    public ExportCheckinOfficer(int officerSTT, String officerName, int officerNumber, int officerMonth, int officerWorkShift, int officerUncompletedShift) {
        this.officerSTT = officerSTT;
        this.officerName = officerName;
        this.officerNumber = officerNumber;
        this.officerMonth = officerMonth;
        this.officerWorkShift = officerWorkShift;
        this.officerUncompletedShift = officerUncompletedShift;
    }

    private int officerSTT;
    private String officerName;
    private int officerNumber;
    private int officerMonth;
    private int officerWorkShift;
    private int officerUncompletedShift;
    public int getOfficerSTT() {
        return officerSTT;
    }
    public void setOfficerSTT(int officerSTT) {
        this.officerSTT = officerSTT;
    }
    public String getOfficerName() {
        return officerName;
    }
    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }
    public int getOfficerNumber() {
        return officerNumber;
    }
    public void setOfficerNumber(int officerNumber) {
        this.officerNumber = officerNumber;
    }
    public int getOfficerMonth() {
        return officerMonth;
    }
    public void setOfficerMonth(int officerMonth) {
        this.officerMonth = officerMonth;
    }
    public int getOfficerWorkShift() {
        return officerWorkShift;
    }
    public void setOfficerWorkShift(int officerWorkShift) {
        this.officerWorkShift = officerWorkShift;
    }
    public int getOfficerUncompletedShift() {
        return officerUncompletedShift;
    }
    public void setOfficerUncompletedShift(int officerUncompletedShift) {
        this.officerUncompletedShift = officerUncompletedShift;
    }
    public static ObservableList getCheckinDetail() {
        ObservableList<ExportCheckinOfficer> exportCheckinofficers = FXCollections.observableArrayList();
        Gson gson = new Gson();
        try {
            ArrayList<ExportCheckinOfficer> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/officerDetail.json");
            Type type = new TypeToken<ArrayList<ExportCheckinOfficer>>() {
            }.getType();
            alist = gson.fromJson(reader, type);
            exportCheckinofficers = FXCollections.observableArrayList(alist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportCheckinofficers;
    }
    public static void exportOfficer(ObservableList exportCheckinDetail) throws IOException {

        List<ExportCheckinOfficer> list = exportCheckinDetail;

        StringBuilder str = new StringBuilder("");

        str.append("STT").append(";");
        str.append("officer Name").append(";");
        str.append("officer Number").append(";");
        str.append("Month").append(";");
        str.append("Work Shift").append(";");
        str.append("Uncompleted Shift");
        str.append("\n");

        for (ExportCheckinOfficer eachstring : list) {
            str.append(eachstring.getOfficerSTT()).append(";");
            str.append(eachstring.getOfficerName()).append(";");
            str.append(eachstring.getOfficerNumber()).append(";");
            str.append(eachstring.getOfficerMonth()).append(";");
            str.append(eachstring.getOfficerWorkShift()).append(";");
            str.append(eachstring.getOfficerUncompletedShift());
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/hust/workattendanceapp/data/csvdata/checkinOfficer.csv"));
        writer.write(commaseparatedlist);

        writer.close();
    }
}
