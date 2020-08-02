package mz.ac.ucmins.Model.sms;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Group implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    private final static long serialVersionUID = 4977007908904495355L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}