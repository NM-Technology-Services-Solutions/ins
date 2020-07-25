package co.mz.ins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

import co.mz.ins.Adapters.ResultSeachAdapter;
import co.mz.ins.Model.Amostra;

public class AmostraSearchResult extends AppCompatActivity {
    View v;
    private RecyclerView recyclerView;
    private List<Amostra> item_amostraList;

    public AmostraSearchResult() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amostra_search_result);

        item_amostraList = new ArrayList<>();
        item_amostraList.add((new Amostra("23/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("24/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("25/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("26/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("23/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("24/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("25/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("26/07/2020","Teste bla bla bla la")));

        recyclerView = findViewById(R.id.amostra_resutl_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ResultSeachAdapter(this,item_amostraList));

    }

    public void backSearchScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), RequestAmostra.class);
        startActivity(intent);
    }
}