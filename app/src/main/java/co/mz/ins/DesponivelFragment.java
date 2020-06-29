package co.mz.ins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.mz.ins.Adapters.RecylerViewAdapter;
import co.mz.ins.Model.ItemResult;


public class DesponivelFragment extends Fragment {
     View v;
     private RecyclerView recyclerView;
     private List<ItemResult> itemResultList;

    public DesponivelFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_desponivel, container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.disponivel);
        RecylerViewAdapter recylerViewAdapter = new RecylerViewAdapter(getContext(), itemResultList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recylerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemResultList = new ArrayList<>();
        itemResultList.add(new ItemResult("848396068","Horacio Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396069","Junior Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
        itemResultList.add(new ItemResult("848396067","Ezequias Vilanculo", R.drawable.logotipo));
    }
}