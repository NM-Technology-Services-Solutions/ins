package mz.ac.ucmins.api.sms;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.preference.PreferenceManager;

import mz.ac.ucmins.api.AddCookiesInterceptor;
import mz.ac.ucmins.api.ReceivedCookiesInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SMSAPI {
    private static final String TAG = ".SMSAPI";
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static String BASE_URL = "";
    private static Retrofit retrofit = null;
    public SmsEndpoint userService;

    public static SmsEndpoint getSenaiteEndpoint(Context c) {
        preferences = PreferenceManager.getDefaultSharedPreferences(c);
        editor = preferences.edit();
        BASE_URL = setBaseUrlFromPreferences(preferences.getString("mensageiro_base_url_preference", "https://textit.in/api/v2/"));


        //resultsAvailableService= senaiteEndpoint;
        Log.d(TAG, "The end point is now: " + BASE_URL);
        return getClient(BASE_URL, c).create(SmsEndpoint.class);
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


}
