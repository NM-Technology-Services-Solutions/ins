package mz.ac.ucmins.views;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import co.mz.ucmins.R;
import mz.ac.ucmins.Model.AnalysisRequestList;
import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestAmostra extends AppCompatActivity {
private TextInputEditText editText;

    ImageView amostra_backArrow_btn;
    SenaiteEndpoint sampleService;
    AnalysisResquest aR;
    AnalysisRequestList aRl;
    PatientList pL;
    Patient p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_amostra);

        amostra_backArrow_btn = findViewById(R.id.amostra_backArrow_btn);
        editText = findViewById(R.id.codigoAmostra);
        sampleService = new ApiUtils().getSenaiteEndpoint(this);
        aR = new AnalysisResquest();
        p = new Patient();
        pL = new PatientList();

    }

    public void backHome(View view) {
        Intent intent = new Intent(getApplicationContext(), HomePage.class);

        //Adding transiction between screens

        Pair [] pairs = new Pair[1];

        pairs[0] = new Pair <View,String>(amostra_backArrow_btn, "trans_back_arrow_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RequestAmostra.this, pairs);

        startActivity(intent, options.toBundle());

    }

    public void procurar(View view) {
        String code = editText.getText().toString();
           searchSampleById(code);

    }
// putextras the only solution


    private AnalysisResquest searchSampleById(String code) {
        Call<AnalysisRequestList> call = sampleService.getAnalysisRequestList(code);
        System.out.println("Token: "+ code);
         aRl= new AnalysisRequestList();
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
                //res = ar.getItems();
                aRl = response.body();
                aR=aRl.getItems().get(0);
                System.out.println(aRl.getCount());
                System.out.println(aR.getCreatorFullName());

                Intent intent = new Intent(getApplicationContext(), GetPatient.class);
                intent.putExtra("result", aR);
                //intent.putExtra("patient",patient);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }
        });
        System.out.println("liu" + aR.getAuthor());
        return aR;
    }
}