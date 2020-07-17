package co.mz.ins.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIResultList {

        @SerializedName("count")
        @Expose
        private int count;
        @SerializedName("pagesize")
        @Expose
        private int pagesize;
        @SerializedName("items")
        @Expose
        private List<Object> items = null;
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

        public List<Object> getItems() {
            return items;
        }

        public void setItems(List<Object> items) {
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
