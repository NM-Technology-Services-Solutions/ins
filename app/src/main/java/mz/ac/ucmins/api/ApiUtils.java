package mz.ac.ucmins.api;

import android.app.Application;
import android.content.Context;

import java.util.List;

import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.Patient;
import co.mz.ucmins.R;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils extends Application {
    private static Retrofit retrofit = null;
    static List<AnalysisResquest> res;
    static Patient p;
    static String token ;
    public SenaiteEndpoint userService;

   // public static final String BASE_URL = "http://192.168.20.110/demo/";

    public  SenaiteEndpoint getSenaiteEndpoint(Context c, String BASE_URL){
        return  this.getClient(BASE_URL, c).create(SenaiteEndpoint.class);
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        userService=new ApiUtils().getSenaiteEndpoint(this, getString(R.string.apibaseurl));
    }



    public  Retrofit getClient(String url, Context c) {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new AddCookiesInterceptor(c)); // VERY VERY IMPORTANT
        builder.addInterceptor(new ReceivedCookiesInterceptor(c)); // VERY VERY IMPORTANT
        client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
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


