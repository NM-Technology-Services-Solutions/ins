package mz.ac.ucmins.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mz.ac.ucmins.Adapters.ResultSeachAdapter;
import mz.ac.ucmins.Model.Amostra;
import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.Patient;
import co.mz.ucmins.R;

public class AmostraSearchResult extends AppCompatActivity {
    View v;
    private RecyclerView recyclerView;
    private List<Amostra> item_amostraList;
    private TextView patientContact;
    private TextView patientNome;

    public AmostraSearchResult() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amostra_search_result);
        List<AnalysisResquest> aRL = (List<AnalysisResquest>) getIntent().getSerializableExtra("result");
        Patient pat = (Patient) getIntent().getSerializableExtra("patient");
        patientContact= findViewById(R.id.paciente_celular);
        patientNome= findViewById(R.id.paciente_name);

        patientNome.setText(pat.getFullname());
        patientContact.setText(pat.getMobilePhone());
        item_amostraList = new ArrayList<>();
        for(AnalysisResquest ar: aRL){
            item_amostraList.add((new Amostra(ar.getCreationDate(),ar.getSampleTypeTitle())));
        }


        recyclerView = findViewById(R.id.amostra_resutl_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ResultSeachAdapter(this,item_amostraList));

    }

    public void backSearchScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), RequestAmostra.class);
        startActivity(intent);
    }
}