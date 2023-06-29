package hust.workattendanceapp.model.officer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OfficerOverallAttendance1Data {

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public OfficerOverallAttendance1Data(LocalDate date, LocalDateTime startTime, LocalDateTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStringDate() {
        return this.date.getDayOfMonth() + "";
    }

    public String getStringStartTime() {
        return this.startTime.getHour()+":"+this.startTime.getMinute();
    }

    public String getStringEndTime() {
        return this.endTime.getHour()+":"+this.startTime.getMinute();
    }


    public static ObservableList getData() {
        ObservableList<OfficerOverallAttendance1Data> dataListOfficer = FXCollections.observableArrayList();

        Gson gson = new Gson();
        try {
            ArrayList<OfficerOverallAttendance1Data> alist;
            FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/OfficerOverall.json");
            Type type = new TypeToken<ArrayList<OfficerOverallAttendance1Data>>() {
            }.getType();

            alist = gson.fromJson(reader, type);

            dataListOfficer = FXCollections.observableArrayList(alist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataListOfficer;

    }


    public static List<TestDateReader> test() throws FileNotFoundException {
        class LocalDateSerializer implements JsonSerializer<LocalDate> {
            private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
                return new JsonPrimitive(formatter.format(localDate));
            }
        }

        class LocalDateTimeSerializer implements JsonSerializer <LocalDateTime> {
            private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

            @Override
            public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
                return new JsonPrimitive(formatter.format(localDateTime));
            }
        }

        class LocalDateDeserializer implements JsonDeserializer < LocalDate > {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
            }
        }

        class LocalDateTimeDeserializer implements JsonDeserializer < LocalDateTime > {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDateTime.parse(json.getAsString(),
                        DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
            }
        }


        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        FileReader reader = new FileReader("src/main/java/hust/workattendanceapp/data/OfficerOverall.json");
        Type type = new TypeToken<List<TestDateReader>>() {}.getType();

        List<TestDateReader> results = gson.fromJson(reader, type);

        return results;
    }


    public OfficerOverallAttendance1Data() {}

    public static void main (String args[]) throws FileNotFoundException {
        OfficerOverallAttendance1Data data = new OfficerOverallAttendance1Data();
        data.test();
        System.out.println(data.test().get(0).getStringDate());
    }

//    class LocalDateSerializer implements JsonSerializer<LocalDate> {
//        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        @Override
//        public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
//            return new JsonPrimitive(formatter.format(localDate));
//        }
//    }


}
