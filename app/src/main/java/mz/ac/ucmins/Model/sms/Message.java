package mz.ac.ucmins.Model.sms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    @SerializedName("urns")
    @Expose
    private List<String> urns = null;
    @SerializedName("contacts")
    @Expose
    private List<String> contactsUUID = null;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -1547048783508405766L;

    public List<String> getUrns() {
        return urns;
    }

    public void setUrns(List<String> urns) {
        this.urns = urns;
    }

    public List<String> getContactsUUID() {
        return contactsUUID;
    }

    public void setContactsUUID(List<String> contacts) {
        this.contactsUUID = contacts;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}