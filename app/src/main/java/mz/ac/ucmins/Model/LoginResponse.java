package  mz.ac.ucmins.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;



public class LoginResponse implements Serializable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("pagesize")
    @Expose
    private int pagesize;
    @SerializedName("items")
    @Expose
    private List<User> items = null;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("_runtime")
    @Expose
    private double runtime;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("previous")
    @Expose
    private Object previous;
    private final static long serialVersionUID = -3598440127683897972L;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

}
