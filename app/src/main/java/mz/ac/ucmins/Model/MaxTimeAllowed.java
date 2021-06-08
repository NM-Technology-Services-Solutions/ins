package mz.ac.ucmins.Model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MaxTimeAllowed implements Serializable
{

    @SerializedName("hours")
    @Expose
    private String hours;
    @SerializedName("minutes")
    @Expose
    private String minutes;
    @SerializedName("days")
    @Expose
    private String days;
    private final static long serialVersionUID = -7228103322033318179L;

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

}