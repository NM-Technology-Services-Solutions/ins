package co.mz.ins.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SampleType {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("api_url")
    @Expose
    private String apiUrl;

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