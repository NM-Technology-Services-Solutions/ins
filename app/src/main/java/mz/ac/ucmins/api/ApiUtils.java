package mz.ac.ucmins.api;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.preference.PreferenceManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils extends Application {
    private static Retrofit retrofit = null;
    private static final String TAG = ".ApiUtils";

    public SenaiteEndpoint userService;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;

    public static String BASE_URL = "";


    public static SenaiteEndpoint getSenaiteEndpoint(Context c) {
        preferences = PreferenceManager.getDefaultSharedPreferences(c);
        editor = preferences.edit();
        BASE_URL = setBaseUrlFromPreferences(preferences.getString("senaite_base_url_preference", "http://192.168.0.4:8080/smartlabs/@@API/senaite/v1/"));


        //resultsAvailableService= senaiteEndpoint;
        Log.d(TAG, "The end point is now: " + BASE_URL);
        return getClient(BASE_URL, c).create(SenaiteEndpoint.class);
    }

    private static String setBaseUrlFromPreferences(String base_url) {

        return base_url;
    }

    public static Retrofit getClient(String url, Context c) {
        if (retrofit == null) {

            OkHttpClient client;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.addInterceptor(new AddCookiesInterceptor(c)); // VERY VERY IMPORTANT
            builder.addInterceptor(new ReceivedCookiesInterceptor(c)); // VERY VERY IMPORTANT
            client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        userService = new ApiUtils().getSenaiteEndpoint(this);
    }


    public void getSenaite() {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new AddCookiesInterceptor(this)); // VERY VERY IMPORTANT
        builder.addInterceptor(new ReceivedCookiesInterceptor(this)); // VERY VERY IMPORTANT
        client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("my-base") // REQUIRED
                .client(client) // VERY VERY IMPORTANT
                .addConverterFactory(GsonConverterFactory.create())
                .build(); // REQUIRED


    }



}


