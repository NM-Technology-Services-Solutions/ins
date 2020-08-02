package mz.ac.ucmins.Model.sms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fields implements Serializable {

    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("side_kick")
    @Expose
    private String sideKick;
    private final static long serialVersionUID = 3581689710021621769L;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSideKick() {
        return sideKick;
    }

    public void setSideKick(String sideKick) {
        this.sideKick = sideKick;
    }

}
