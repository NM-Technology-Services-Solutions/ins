package mz.ac.ucmins.Model.sms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetContactsResponse implements Serializable {

    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Contact> results = null;
    private final static long serialVersionUID = 2306996913242450452L;

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Contact> getResults() {
        return results;
    }

    public void setResults(List<Contact> results) {
        this.results = results;
    }

}
