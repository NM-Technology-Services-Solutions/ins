package mz.ac.ucmins.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.mz.ucmins.R;
import mz.ac.ucmins.Model.ItemResult;
import mz.ac.ucmins.firebase.FirebaseClient;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {
    Context mContext;
    List<ItemResult> mData, selected;
    Dialog mDialog;
    private FloatingActionButton fab;

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
                final ItemResult data = mData.get(myViewHolder.getAdapterPosition());
                data.setSelected(!data.isSelected());
                myViewHolder.chck.setColorFilter((data.isSelected()? Color.GREEN: Color.WHITE));
            }
        });


        myViewHolder.item_result.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView dialog_nome = (TextView) mDialog.findViewById(R.id.none_dialog);
                TextView dialog_celular = (TextView) mDialog.findViewById(R.id.nr_dialog);
                ImageView dialog_img = (ImageView) mDialog.findViewById(R.id.img_dialog);
                Button sendNotificationButton = mDialog.findViewById(R.id.send_sample_request_notification_button);


                final List<ItemResult> toSendData = new ArrayList<ItemResult>();
                for (ItemResult iR: mData) {
                    if(iR.isSelected()){
                        toSendData.add(iR);
                    }

                }

                dialog_nome.setText(" Solicitar envio Notificacoes ");
                dialog_celular.setText(toSendData.size()+ " Notificacoes Serao Enviadas");
                dialog_img.setImageResource(mData.get(myViewHolder.getAdapterPosition()).getImg());
                sendNotificationButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendSampleRequestNotification(toSendData);
                    }
                });
                //Toast.makeText(mContext,"Tu clicaste em: "+String.valueOf(myViewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                mDialog.show();
                return false;
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



    }

    public void sendSampleRequestNotification(List<ItemResult> toSendData){
        Toast.makeText(mContext,"Tu clicaste em: "+ mData.size(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(mContext, GetPatient.class);
//        intent.putExtra("itemsToSend", (Serializable) toSendData);
//        //intent.putExtra("patient",patient);
//        mContext.startActivity(intent);

        // The topic name can be optionally prefixed with "/topics/".
        String topic = "highScores";

        FirebaseClient firebaseClient = new FirebaseClient();
        firebaseClient.db.collection("contacts")
                .add(toSendData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("sucess");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("failure");

                    }
                });


    }






    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
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
           // fab = (FloatingActionButton) itemView.findViewById(R.id.fab);



        }
    }
}
