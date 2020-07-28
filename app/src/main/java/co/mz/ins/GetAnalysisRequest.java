package co.mz.ins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.mz.ins.Model.AnalysisRequestList;
import co.mz.ins.Model.AnalysisResquest;
import co.mz.ins.Model.Patient;
import co.mz.ins.Model.PatientList;
import co.mz.ins.api.ApiUtils;
import co.mz.ins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAnalysisRequest extends Activity {

    private SenaiteEndpoint sampleService;
    private Patient p;
    private PatientList pL;
    Patient pat ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnalysisResquest aR = (AnalysisResquest) getIntent().getSerializableExtra("result");
        pat = (Patient) getIntent().getSerializableExtra("patient");
        sampleService = new ApiUtils().getSenaiteEndpoint(this, getString(R.string.apibaseurl));
        //aR=new AnalysisResquest();
        p= new Patient();
        pL = new PatientList();
        getPatientSamples();

    }

    private void showResults(AnalysisResquest aR) {
        if (aR!=null){
            System.out.println(aR.getApiUrl());
            // Patient patient = getPatient(aR);
            Intent intent = new Intent(getApplicationContext(), AmostraSearchResult.class);
            intent.putExtra("result", aR);
            intent.putExtra("patient",pat);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getApplicationContext(), NotFoundAmostra.class);
            startActivity(intent);
        }
    }

    private void getPatientSamples() {
        Call<AnalysisRequestList> call = sampleService.getAnalysisRequestList();
        System.out.println("Token: "+ p.getFirstname());

        call.enqueue(new Callback<AnalysisRequestList>() {

            @Override
            public void onResponse(Call<AnalysisRequestList> call, Response<AnalysisRequestList> response) {
                int statusCode = response.code();

                System.out.println(statusCode);

                String x= new Gson().toJson(response.body());
                String y= new Gson().toJson(response.headers());

                System.out.println(x);
                System.out.println(y);
                System.out.println(call.request().url());
                List<AnalysisResquest> arL = new ArrayList<AnalysisResquest>();
                //res = ar.getItems();
                for(AnalysisResquest ar: response.body().getItems()){
                    if(ar.getPatient()!=null) {
                        if (ar.getPatient().getUid().equals(pat.getUid())) {
                            arL.add(ar);
                        }
                    }

                }

                System.out.println("Cheguei ate aqui: "+arL.size());


                if (!arL.isEmpty()){
                    //System.out.println(aR.getApiUrl());
                    // Patient patient = getPatient(aR);
                    Intent intent = new Intent(getApplicationContext(), AmostraSearchResult.class);
                    intent.putExtra("result", (Serializable) arL);
                    intent.putExtra("patient",pat);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(), NotFoundAmostra.class);
                    startActivity(intent);
                }


            }

            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
