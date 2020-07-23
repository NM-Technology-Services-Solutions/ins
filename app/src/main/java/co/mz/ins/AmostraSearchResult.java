package co.mz.ins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.amostra_search_result, container,false);
        recyclerView = v.findViewById(R.id.amostra_resutl_item);

       ResultSeachAdapter resultSeachAdapter = new ResultSeachAdapter(this, item_amostraList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(resultSeachAdapter);
        return v;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item_amostraList = new ArrayList<>();
        item_amostraList.add((new Amostra("23/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("24/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("25/07/2020","Teste bla bla bla la")));
        item_amostraList.add((new Amostra("26/07/2020","Teste bla bla bla la")));

        setContentView(R.layout.amostra_search_result);
    }

    public void backSearchScreen(View view) {
    }
}