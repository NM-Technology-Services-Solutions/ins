package co.mz.ins.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.mz.ins.Model.ItemResult;
import co.mz.ins.R;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {
    Context mContext;
    List<ItemResult> mData;
    Dialog mDialog;

    public RecylerViewAdapter(Context mContext, List<ItemResult> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_result, parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(v);

        mDialog = new Dialog(mContext);
        mDialog.setContentView(R.layout.dialog_item);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        myViewHolder.item_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_nome = (TextView) mDialog.findViewById(R.id.none_dialog);
                TextView dialog_celular = (TextView) mDialog.findViewById(R.id.nr_dialog);
                ImageView dialog_img = (ImageView) mDialog.findViewById(R.id.img_dialog);

                dialog_nome.setText(mData.get(myViewHolder.getAdapterPosition()).getName());
                dialog_celular.setText(mData.get(myViewHolder.getAdapterPosition()).getPhone());
                dialog_img.setImageResource(mData.get(myViewHolder.getAdapterPosition()).getImg());
                //Toast.makeText(mContext,"Tu clicaste em: "+String.valueOf(myViewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                mDialog.show();
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final ItemResult data = mData.get(position);
        holder.textView_nome.setText(data.getName());
        holder.textView_phone.setText(data.getPhone());
        holder.img.setImageResource(data.getImg());
        holder.textView_nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setSelected(!data.isSelected());
                holder.chck.setVisibility(data.isSelected()? View.VISIBLE: View.INVISIBLE);
            }
        });

    }






    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_result;
        private TextView textView_nome;
        private TextView textView_phone;
        private  ImageView chck;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_result = (LinearLayout) itemView.findViewById(R.id.result_item_id);
            textView_nome= (TextView) itemView.findViewById(R.id.paciente_name);
            textView_phone= (TextView) itemView.findViewById(R.id.nr_celular);
            chck= itemView.findViewById(R.id.chck);
            img= (ImageView) itemView.findViewById(R.id.img_result);
        }
    }
}
