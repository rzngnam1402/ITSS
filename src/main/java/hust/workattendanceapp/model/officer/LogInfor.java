package hust.workattendanceapp.model.officer;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogInfor {

    private int officer_id;
    private LocalDateTime timeStamp;
    private int devide;

    @Override
    public int hashCode() {
        return Objects.hash(devide, officer_id,timeStamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LogInfor other = (LogInfor) obj;
        return devide == other.devide && officer_id == other.officer_id && Objects.equals(timeStamp, other.timeStamp);
    }

    public int getOfficer_id() {
        return officer_id;
    }

    public void setOfficer_id(int id) {
        this.officer_id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getDevide() {
        return devide;
    }

    public void setDevide() {
        this.devide = devide;
    }
}
