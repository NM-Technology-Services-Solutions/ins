package co.mz.ins.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgeSplitted {

    @SerializedName("month")
    @Expose
    private List<Object> month = null;
    @SerializedName("day")
    @Expose
    private List<Object> day = null;
    @SerializedName("year")
    @Expose
    private List<Object> year = null;

    public List<Object> getMonth() {
        return month;
    }

    public void setMonth(List<Object> month) {
        this.month = month;
    }

    public List<Object> getDay() {
        return day;
    }

    public void setDay(List<Object> day) {
        this.day = day;
    }

    public List<Object> getYear() {
        return year;
    }

    public void setYear(List<Object> year) {
        this.year = year;
    }

}