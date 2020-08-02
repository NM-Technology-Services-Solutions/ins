package mz.ac.ucmins.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import co.mz.ucmins.R;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPatient extends Activity {
    SenaiteEndpoint sampleService;
    private PatientList pL;
    private Patient p;
    AnalysisResquest aR;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         aR = (AnalysisResquest) getIntent().getSerializableExtra("result");
        p = new Patient();
        sampleService = new ApiUtils().getSenaiteEndpoint(this, getString(R.string.apibaseurl));
        //aR=new AnalysisResquest();

        pL = new PatientList();
        getPatient(aR);

    }

    private Patient getPatient(final AnalysisResquest aR) {

        Call<PatientList> call = sampleService.getPatient(aR.getPatient().getUid());
        call.enqueue(new Callback<PatientList>() {


            @Override
            public void onResponse(Call<PatientList> call, Response<PatientList> response) {
                int statusCode = response.code();

                System.out.println(statusCode);

                String x= new Gson().toJson(response.body());
                String y= new Gson().toJson(response.headers());
                p=response.body().getItems().get(0);
                System.out.println("getP "+call.request().url());

                Intent intent = new Intent(getApplicationContext(), GetAnalysisRequest.class);
                intent.putExtra("patient",p);
                intent.putExtra("result",aR);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<PatientList> call, Throwable t) {

            }
        });



        return  p;

    }


}
