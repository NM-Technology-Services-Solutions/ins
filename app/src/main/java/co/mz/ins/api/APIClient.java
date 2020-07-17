package co.mz.ins.api;


import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import java.util.List;

import co.mz.ins.Model.AnalysisRequestList;
import co.mz.ins.Model.AnalysisResquest;
import co.mz.ins.Model.Patient;
import co.mz.ins.Model.PatientList;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient extends Application {

    private static Retrofit retrofit = null;
    static List<AnalysisResquest>  res;
    static Patient p;
    static String token ;
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

    public static List<AnalysisResquest> getAnalysisReq(SenaiteEndpoint endpoint, String token){


        Call<AnalysisRequestList> call =endpoint.getAnalysisRequestList();
        System.out.println("Token: "+ token);

        call.enqueue(new Callback<AnalysisRequestList>() {
            @Override
            public void onResponse(Call<AnalysisRequestList> call, Response<AnalysisRequestList> response) {
                int statusCode = response.code();

                System.out.println(statusCode);

                    String x= new Gson().toJson(response.body());
                    String y= new Gson().toJson(response.headers());

                System.out.println(x);
                System.out.println(y);
                //res = ar.getItems();
            }
            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }

        });
        return res;

    }


    public static Patient getPatient(String uid, SenaiteEndpoint endpoint){
        Call<PatientList> call = endpoint.getPatient(uid);
        call.enqueue(new Callback<PatientList>() {
            @Override
            public void onResponse(Call<PatientList> call, Response<PatientList> response) {
                int statusCode = response.code();

                PatientList ar = response.body();

                p= ar.getItems().get(0);

            }
            @Override
            public void onFailure(Call<PatientList> call, Throwable t) {
                // Log error here since request failed
            }

        });
        return p;

    }













}
