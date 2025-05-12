package Backend_Java.Model;

import java.time.LocalDateTime;

public class Result {
    private String personName;
    private LocalDateTime time;
    private double mark;

    public Result(String personName, LocalDateTime time, double mark) {
        this.personName = personName;
        this.time = time;
        this.mark = mark;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
