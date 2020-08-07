package mz.ac.ucmins.views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mz.ac.ucmins.Adapters.RecylerViewAdapter;
import mz.ac.ucmins.Model.AnalysisRequestList;
import mz.ac.ucmins.Model.AnalysisResquest;
import mz.ac.ucmins.Model.ItemResult;
import co.mz.ucmins.R;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class DesponivelFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    RecylerViewAdapter recylerViewAdapter;
    private List<ItemResult> itemResultList;
    SenaiteEndpoint resultsAvailableService;
    public int elementcount;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    public DesponivelFragment() {
        elementcount=0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_desponivel, container,false);
        recyclerView = v.findViewById(R.id.disponivel);


        registerForContextMenu(recyclerView);

        recylerViewAdapter = new RecylerViewAdapter(getContext(), itemResultList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recylerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultsAvailableService = new ApiUtils().getSenaiteEndpoint(this.getContext(), getString(R.string.apibaseurl));
        itemResultList= doFillResults();
        System.out.println("size" +itemResultList.size());
        preferences = this.getContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        editor = preferences.edit();

        ((ResultsPageContainer) getActivity()).drawBadge();


    }

    private List<ItemResult> doFillResults() {
        Call<AnalysisRequestList> call = resultsAvailableService.getAnalysisRequestList();
        //System.out.println("Token: "+ token);
        itemResultList = new ArrayList<>();
        call.enqueue(new Callback<AnalysisRequestList>() {
            @Override
            public void onResponse(Call<AnalysisRequestList> call, Response<AnalysisRequestList> response) {
                int statusCode = response.code();
                System.out.println(statusCode);

                AnalysisRequestList arl = response.body();
                System.out.println(itemResultList.size());
                for(AnalysisResquest ar: arl.getItems()){
                    System.out.println(ar.getGetClientID());
                    itemResultList.add(new ItemResult(ar.getAuthor(),ar.getGetClientID().toString(), R.drawable.logotipo, false));
                    recylerViewAdapter.notifyDataSetChanged();

                }
                System.out.println("sizeeee "+itemResultList.size());
                String x= new Gson().toJson(response.body());
                String y= new Gson().toJson(response.headers());
                editor.putInt("resultados_disponiveis", itemResultList.size());
                editor.commit();

                System.out.println("here"+preferences.getAll());
                System.out.println(y);
                //res = ar.getItems();


            }
            @Override
            public void onFailure(Call<AnalysisRequestList> call, Throwable t) {
                t.printStackTrace();
            }

        });
        System.out.println("Result List Size"+itemResultList.size());
        return itemResultList;
    }
}