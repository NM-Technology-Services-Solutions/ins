package mz.ac.ucmins.views;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.mz.ucmins.R;
import mz.ac.ucmins.Adapters.ResultsDetailsAdapter;
import mz.ac.ucmins.Model.Analysis;
import mz.ac.ucmins.Model.AnalysisList;
import mz.ac.ucmins.Model.AnalysisResponseSet;
import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.LoginResponse;
import mz.ac.ucmins.Model.Patient;
import mz.ac.ucmins.Model.PatientList;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import mz.ac.ucmins.api.SenaiteService;
import retrofit2.Call;

public class ResultDetailsActivity extends AppCompatActivity {
    SenaiteService analysisService;
    SenaiteEndpoint senaiteEndpoint;
    private PatientList pL;
    private Patient p;
    AnalysisResquest aR;
    ResultsDetailsAdapter adapter;
    List<Analysis> AnalysisList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // sampleService = new ApiUtils().getSenaiteEndpoint(this);
        senaiteEndpoint = ApiUtils.getSenaiteEndpoint(getApplicationContext());
        analysisService = new SenaiteService(senaiteEndpoint);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final AnalysisResquest aR = (AnalysisResquest) this.getIntent().getExtras().getSerializable("analysisResult");
        AnalysisList = new ArrayList<>();

        recyclerView = findViewById(R.id.resultados_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResultsDetailsAdapter(AnalysisList);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


           // Call<AnalysisList> call = sampleService.getAnalysis(arS.getUid());
           // System.out.println(call.request().url());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(AnalysisResponseSet arS: aR.getAnalyses()){
                        try {
                            Log.d("RunnableResuilsActivity", "Chegou aqui");
                            Analysis asss =analysisService.getAnalysisFromSenaite(arS.getUid()).getItems().get(0);
                            AnalysisList.add(asss);
                            System.out.println("This check "+asss.toString());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();

                        }
                    });

                }
            });

        thread.start();



//        System.out.println(AnalysisList.get(1).getTitle());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }
}