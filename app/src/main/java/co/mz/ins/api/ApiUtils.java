package co.mz.ins.api;

import android.app.Application;
import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils extends Application {

    public static final String BASE_URL = "http://192.168.20.110/demo/";

    public static SenaiteEndpoint getSenaiteEndpoint(Context c, String BASE_URL){
        return new APIClient().getClient(BASE_URL, c).create(SenaiteEndpoint.class);
    }

    public void getSenaite(){

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


