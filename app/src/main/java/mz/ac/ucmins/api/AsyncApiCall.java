package mz.ac.ucmins.api;

import android.os.AsyncTask;

public class AsyncApiCall extends AsyncTask<Void, Void, String> {
    private ApiCallback<String> callback;
    private Exception exception;

    public AsyncApiCall(ApiCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            return "Hello my friends";
        } catch (Exception e) {
            exception = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (exception == null) {
            callback.onSuccess(result);
        } else {
            callback.onFailure(exception);
        }
    }
}
