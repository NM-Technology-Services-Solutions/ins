package co.mz.ins.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.mz.ins.Model.Amostra;
import co.mz.ins.R;

public class ResultSeachAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<Amostra> mData;

    public ResultSeachAdapter(Context mContext, List<Amostra> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public ResultSeachAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_amostra_result, parent, false);
        AmostraItem amostraItem = new AmostraItem(view);

        return amostraItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AmostraItem)holder).textView_amostra_descricao.setText(mData.get(position).getDescricao());
        ((AmostraItem)holder).textView_amostra_dataColhida.setText(mData.get(position).getDataColhida());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class AmostraItem extends RecyclerView.ViewHolder {
        private LinearLayout item_amostra_result;
        private TextView textView_amostra_descricao;
        private TextView textView_amostra_dataColhida;
        public AmostraItem(@NonNull View itemView) {
            super(itemView);
            item_amostra_result = (LinearLayout) itemView.findViewById(R.id.item_amostra_result_id);
            textView_amostra_descricao= (TextView) itemView.findViewById(R.id.amostra_descricao);
            textView_amostra_dataColhida= (TextView) itemView.findViewById(R.id.amostra_dataColhida);
        }
    }
}
