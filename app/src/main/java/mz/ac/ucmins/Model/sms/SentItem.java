package mz.ac.ucmins.Model.sms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SentItem implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("urns")
    @Expose
    private List<String> urns = null;
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = null;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    private final static long serialVersionUID = 5989512195276355017L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getUrns() {
        return urns;
    }

    public void setUrns(List<String> urns) {
        this.urns = urns;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
    public class Text implements Serializable
    {

        @SerializedName("base")
        @Expose
        private String base;
        private final static long serialVersionUID = 1364853023897215482L;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

    }

}
