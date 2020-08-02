package mz.ac.ucmins.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Menstrualstatus implements Serializable {

    @SerializedName("OvariesRemovedYear")
    @Expose
    private String ovariesRemovedYear;
    @SerializedName("HysterectomyYear")
    @Expose
    private String hysterectomyYear;
    @SerializedName("Hysterectomy")
    @Expose
    private boolean hysterectomy;
    @SerializedName("OvariesRemovedNum")
    @Expose
    private int ovariesRemovedNum;
    @SerializedName("OvariesRemoved")
    @Expose
    private boolean ovariesRemoved;

    public String getOvariesRemovedYear() {
        return ovariesRemovedYear;
    }

    public void setOvariesRemovedYear(String ovariesRemovedYear) {
        this.ovariesRemovedYear = ovariesRemovedYear;
    }

    public String getHysterectomyYear() {
        return hysterectomyYear;
    }

    public void setHysterectomyYear(String hysterectomyYear) {
        this.hysterectomyYear = hysterectomyYear;
    }

    public boolean isHysterectomy() {
        return hysterectomy;
    }

    public void setHysterectomy(boolean hysterectomy) {
        this.hysterectomy = hysterectomy;
    }

    public int getOvariesRemovedNum() {
        return ovariesRemovedNum;
    }

    public void setOvariesRemovedNum(int ovariesRemovedNum) {
        this.ovariesRemovedNum = ovariesRemovedNum;
    }

    public boolean isOvariesRemoved() {
        return ovariesRemoved;
    }

    public void setOvariesRemoved(boolean ovariesRemoved) {
        this.ovariesRemoved = ovariesRemoved;
    }

}