package mz.ac.ucmins.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import mz.ac.ucmins.Model.Amostra;
import co.mz.ucmins.R;

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

        View itemView;

        if(viewType == R.layout.item_amostra_result){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_amostra_result, parent, false);
        }

        else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.send_notification_button, parent, false);
        }

        return new AmostraItem(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(position == mData.size()) {
            ((AmostraItem)holder).sendNotificationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Button Clicked", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            ((AmostraItem)holder).textView_amostra_descricao.setText(mData.get(position).getDescricao());
            ((AmostraItem)holder).textView_amostra_dataColhida.setText(mData.get(position).getDataColhida());
        }

    }

    @Override
    public int getItemCount() {
        return mData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mData.size()) ? R.layout.send_notification_button : R.layout.item_amostra_result;
    }

    public class AmostraItem extends RecyclerView.ViewHolder {
        public Button sendNotificationButton;
        private LinearLayout item_amostra_result;
        private TextView textView_amostra_descricao;
        private TextView textView_amostra_dataColhida;
        public AmostraItem(@NonNull View itemView) {
            super(itemView);
            item_amostra_result = (LinearLayout) itemView.findViewById(R.id.item_amostra_result_id);
            textView_amostra_descricao= (TextView) itemView.findViewById(R.id.amostra_descricao);
            textView_amostra_dataColhida= (TextView) itemView.findViewById(R.id.amostra_dataColhida);
            sendNotificationButton=itemView.findViewById(R.id.sendNotButton);
        }
    }
}
