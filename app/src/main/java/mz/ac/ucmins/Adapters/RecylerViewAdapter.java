package mz.ac.ucmins.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.mz.ucmins.R;
import mz.ac.ucmins.Model.ItemResult;
import mz.ac.ucmins.firebase.FirebaseClient;
import mz.ac.ucmins.views.ResultDetailsActivity;


public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<ItemResult> mData, selected;
    Dialog mDialog;
    private FloatingActionButton fab;

    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final int HERO = 2;
    private static final String TAG = ".RecylerViewAdapter";
    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;
    private PaginationAdapterCallback mCallback;
    private String errorMsg;
    private int selectCount = 0;
    private OnSelectedListener onSelectedListener;


    public RecylerViewAdapter(Context mContext, OnSelectedListener onSelectedListener) {
        this.mContext = mContext;
        this.mData = new ArrayList<>();
        this.mCallback = (PaginationAdapterCallback) mContext;
        this.onSelectedListener = onSelectedListener;
    }

    public List<ItemResult> getmData() {
        return mData;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  View v;
        //v = LayoutInflater.from(mContext).inflate(R.layout.item_result, parent, false);

        Log.d(TAG, "on create causing issues " + mData.size());
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.item_result, parent, false);
                viewHolder = new ItemResultVH(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.loading_item_result, parent, false);
                viewHolder = new LoadingResultVH(viewLoading);
                break;
            case HERO:
                View viewHero = inflater.inflate(R.layout.no_item_result, parent, false);
                viewHolder = new NoResultVH(viewHero);
                break;
        }
        return viewHolder;
    }

    private void toggleCheckedIcon(RecylerViewAdapter.ItemResultVH holder, int position) {

        if (mData.get(position).isSelected()) {
            //holder.chck.setVisibility(View.GONE);
            holder.chck.setColorFilter(Color.WHITE);
            mData.get(position).setSelected(false);

            selectCount--;
            this.onSelectedListener.onSelected(true);

        } else {
            // holder.chck.setVisibility(View.VISIBLE);
            holder.chck.setColorFilter(Color.RED);
            mData.get(position).setSelected(true);
            selectCount++;
            this.onSelectedListener.onSelected(true);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ItemResult data = mData.get(position);


        Log.d(TAG, "Binding View");
        switch (getItemViewType(position)) {
            case HERO:
                final RecylerViewAdapter.NoResultVH noResultVH = (NoResultVH) holder;
                noResultVH.textView_nome.setText(data.getName());
                noResultVH.textView_phone.setText(data.getPhone());
                noResultVH.img.setImageResource(data.getImg());
                break;
            case ITEM:
                final ItemResultVH itemResultVH = (ItemResultVH) holder;
                itemResultVH.textView_nome.setText(data.getName());
                itemResultVH.textView_phone.setText(data.getPhone());
                itemResultVH.img.setImageResource(data.getImg());
                itemResultVH.item_result.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toggleCheckedIcon(itemResultVH, position);


                    }
                });
                itemResultVH.item_result.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        Context context = view.getContext();
                        Intent intent= new Intent(context, ResultDetailsActivity.class);
                        intent.putExtra("analysisResult",data.getAr());
                        context.startActivity(intent);
                        return true;
                    }
                });
                break;
            case LOADING:
                LoadingResultVH loadingResultVH = (LoadingResultVH) holder;
                if (retryPageLoad) {
                    loadingResultVH.mErrorLayout.setVisibility(View.VISIBLE);
                    loadingResultVH.mProgressBar.setVisibility(View.GONE);

                    loadingResultVH.mErrorTxt.setText(
                            errorMsg != null ?
                                    errorMsg :
                                    mContext.getString(R.string.error_msg_unknown));

                } else {
                    loadingResultVH.mErrorLayout.setVisibility(View.GONE);
                    loadingResultVH.mProgressBar.setVisibility(View.VISIBLE);
                }
                break;
        }


    }

    public void sendSampleRequestNotification(List<ItemResult> toSendData){
        Toast.makeText(mContext,"Tu clicaste em: "+ mData.size(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(mContext, GetPatient.class);
//        intent.putExtra("itemsToSend", (Serializable) toSendData);
//        //intent.putExtra("patient",patient);
//        mContext.startActivity(intent);

        // Save to Firebase".
        Map<String, Object> contacts = new HashMap<>();
        contacts.put("amostra",toSendData);
        FirebaseClient firebaseClient = new FirebaseClient();
        firebaseClient.db.collection("contacts")
                .add(contacts)
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
                        e.printStackTrace();

                    }
                });


    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HERO;
        } else {
            return (position == mData.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
        }
    }

    public int getSelectedCount() {
        return selectCount;
    }

    public void add(ItemResult r) {
        mData.add(r);
        notifyItemInserted(mData.size() - 1);

    }

    public void addAll(List<ItemResult> itemResults) {
        for (ItemResult itemResult : itemResults) {

            add(itemResult);
        }
    }

    public void remove(ItemResult r) {
        int position = mData.indexOf(r);
        if (position > -1) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    /*
        Helpers - Pagination
   _________________________________________________________________________________________________
    */

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new ItemResult());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = mData.size() - 1;
        ItemResult result = getItem(position);

        if (result != null) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public ItemResult getItem(int position) {
        return mData.get(position);
    }

    /**
     * Displays Pagination retry footer view along with appropriate errorMsg
     *
     * @param show
     * @param errorMsg to display if page load fails
     */
    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(mData.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }


    public interface OnSelectedListener {
        void onSelected(boolean selection);

    }
    public interface OnLongPressedListener {
        void onLongPressed(boolean selection);

    }


    public class NoResultVH extends RecyclerView.ViewHolder {
        private LinearLayout item_result;
        private TextView textView_nome;
        private TextView textView_phone;
        private ImageView chck;
        private ImageView img;


        public NoResultVH(@NonNull View itemView) {
            super(itemView);

            item_result = (LinearLayout) itemView.findViewById(R.id.result_item_id);
            textView_nome = (TextView) itemView.findViewById(R.id.paciente_name);
            textView_phone = (TextView) itemView.findViewById(R.id.nr_celular);
            chck = itemView.findViewById(R.id.chck);
            img = (ImageView) itemView.findViewById(R.id.img_result);
            // fab = (FloatingActionButton) itemView.findViewById(R.id.fab);

        }
    }

    public class ItemResultVH extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private LinearLayout item_result;
        private TextView textView_nome;
        private TextView textView_phone;
        private ImageView chck;
        private ImageView img;
        //private OnItemClickListener onItemClickListener;


        public ItemResultVH(@NonNull View itemView) {
            super(itemView);

            item_result = (LinearLayout) itemView.findViewById(R.id.result_item_id);
            textView_nome = (TextView) itemView.findViewById(R.id.paciente_name);
            textView_phone = (TextView) itemView.findViewById(R.id.nr_celular);
            chck = itemView.findViewById(R.id.chck);
            img = (ImageView) itemView.findViewById(R.id.img_result);
            // fab = (FloatingActionButton) itemView.findViewById(R.id.fab);
            //itemView.setOnClickListener(this);
            //img.setOnClickListener(this);
            //item_result.setOnClickListener(this);


        }


        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class LoadingResultVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ProgressBar mProgressBar;
        private ImageButton mRetryBtn;
        private TextView mErrorTxt;
        private LinearLayout mErrorLayout;
        //OnSongClickListener onSongClickListener;

        public LoadingResultVH(View itemView) {
            super(itemView);

            mProgressBar = itemView.findViewById(R.id.loadmore_progress);
            mRetryBtn = itemView.findViewById(R.id.loadmore_retry);
            mErrorTxt = itemView.findViewById(R.id.loadmore_errortxt);
            mErrorLayout = itemView.findViewById(R.id.loadmore_errorlayout);
            //this.onSongClickListener = onSongClickListener;
            mRetryBtn.setOnClickListener(this);
            mErrorLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:

                    showRetry(false, null);
                    mCallback.retryPageLoad();

                    break;
            }
        }
    }
}