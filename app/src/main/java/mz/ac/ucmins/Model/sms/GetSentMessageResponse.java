package mz.ac.ucmins.Model.sms;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;




public class GetSentMessageResponse implements Serializable
{

    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<SentItem> results = null;
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

    public List<SentItem> getResults() {
        return results;
    }

    public void setResults(List<SentItem> results) {
        this.results = results;
    }


}




