package mz.ac.ucmins.Model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("api_url")
    @Expose
    private String apiUrl;
    private final static long serialVersionUID = 6003323270430905355L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

}