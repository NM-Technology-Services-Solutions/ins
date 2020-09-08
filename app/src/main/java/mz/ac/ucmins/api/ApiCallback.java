package mz.ac.ucmins.api;

public interface ApiCallback<T> {

        public void onSuccess(T data);

        public void onFailure(Exception e);

}
