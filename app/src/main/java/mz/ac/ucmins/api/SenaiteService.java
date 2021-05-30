package mz.ac.ucmins.api;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.mz.ucmins.R;
import mz.ac.ucmins.Adapters.RecylerViewAdapter;
import mz.ac.ucmins.Model.AnalysisRequestList;
import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.ItemResult;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import retrofit2.Call;
import retrofit2.Response;

public class SenaiteService extends Application {


    private static final String TAG = ".SenaiteService";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    public int elementcount;
    RecylerViewAdapter recylerViewAdapter;
    SenaiteEndpoint resultsAvailableService;
    private RecyclerView recyclerView;
    private List<ItemResult> itemResultList;
    private String user, pass;


    public SenaiteService(SenaiteEndpoint senaiteEndpoint) {

        // preferences = c.getSharedPreferences("LoginPref", MODE_PRIVATE);
        // editor = preferences.edit();

        resultsAvailableService = senaiteEndpoint;


    }

    String getBaseUrl() {
        if (preferences.contains("BASE_URL")) {
            return preferences.getString("BASE_URL"+"/@@API/senaite/v1/", "");


        }
        return getString(R.string.apibaseurl);
    }

    public AnalysisRequestList getResults(int limit, int b_start) throws IOException {


        Call<AnalysisRequestList> call = resultsAvailableService.getAnalysisRequestList(limit, b_start);
        System.out.println(call.request().url());
        Response<AnalysisRequestList> analysisRequestListResponse = call.execute();

        if (analysisRequestListResponse.isSuccessful()) {
            System.out.println(analysisRequestListResponse.body().getCount());
            return analysisRequestListResponse.body();
        } else {
            return null;
        }
    }

    public Patient getPatient(String uid) throws IOException {
        Call<PatientList> call = resultsAvailableService.getPatient(uid);
        Response<PatientList> patientListResponse = call.execute();
        Log.d(TAG, "Getting Pacients" + call.request().url());
        if (patientListResponse.isSuccessful()) {
            Log.d(TAG, "GettingPacientSuccess?" + patientListResponse.raw());
            return patientListResponse.body().getItems().get(0);
        } else {
            return null;
        }
    }

    public List<Patient> getPatients() throws IOException {
        Call<PatientList> call = resultsAvailableService.getPatients();
        Response<PatientList> patientListResponse = call.execute();
        if (patientListResponse.isSuccessful()) {
            return patientListResponse.body().getItems();
        } else {
            return null;
        }

    }

    public List<ItemResult> getSamplesAndPatients(List<AnalysisResquest> analysisRequestList) throws IOException {
        itemResultList = new ArrayList<ItemResult>();
        for (AnalysisResquest aR : analysisRequestList) {

            if (aR.getPatient() != null) {

                itemResultList.add(new ItemResult(aR, getPatient(aR.getPatient().getUid())));
            }


        }
        return itemResultList;
    }




/*

    public void fetchPage(int limit, int b_start) {
        //Call<AnalysisRequestList> call = resultsAvailableService.getAnalysisRequestList(limit, b_start);
        //System.out.println("Token: "+ token);
       // itemResultList = new ArrayList<>();
        getAnalysisRequests(limit,b_start).enqueue(new Callback<AnalysisRequestList>() {
            @Override
            public void onResponse(Call<AnalysisRequestList> call, Response<AnalysisRequestList> response) {
               Log.d(TAG, "Begin loading Results");
               fecthResults(response);

            }
            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }

        });
        //System.out.println("Result List Size"+itemResultList.size());

    }



    */
/**
 * Performs a Retrofit call to the Music Promo API.
 *//*

    private Call<AnalysisRequestList> getAnalysisRequests(int limit, int b_start) { //2
        Log.d(TAG,"getResults:");
        return resultsAvailableService.getAnalysisRequestList(limit, b_start);
    }

    */
    /*
     * Extracts List<Result> from response
     *//*

    private AnalysisRequestList fecthResults(Response<AnalysisRequestList> response) {

        response.body();
        //return itemResults;
    }


*/


}
