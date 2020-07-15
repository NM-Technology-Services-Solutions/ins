package co.mz.ins.Model;



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("pagesize")
    @Expose
    private int pagesize;
    @SerializedName("items")
    @Expose
    List<Item> items = null;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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
    public class Item {

        @SerializedName("username")
        @Expose
         public String username;
        @SerializedName("authenticated")
        @Expose
        boolean authenticated;
        @SerializedName("groups")
        @Expose
        List<Object> groups = null;
        @SerializedName("roles")
        @Expose
         List<String> roles = null;
        @SerializedName("api_url")
        @Expose
        String apiUrl;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public List<Object> getGroups() {
            return groups;
        }

        public void setGroups(List<Object> groups) {
            this.groups = groups;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

    }
}


