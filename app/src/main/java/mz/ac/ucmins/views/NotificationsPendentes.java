package mz.ac.ucmins.views;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import co.mz.ucmins.R;
import mz.ac.ucmins.Adapters.AdapterListInbox;
import mz.ac.ucmins.Model.Inbox;
import mz.ac.ucmins.Model.ItemResult;
import mz.ac.ucmins.Model.sms.Message;
import mz.ac.ucmins.Model.sms.SendSmsResponse;
import mz.ac.ucmins.api.sms.SMSAPI;
import mz.ac.ucmins.api.sms.SmsEndpoint;
import mz.ac.ucmins.firebase.FirebaseClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsPendentes extends AppCompatActivity implements FirebaseClient.OnCustomObjectListener {
    private static final String TAG = ".NotificationsPendentes";
    List<ItemResult> itemResultList;
    SMSAPI smsapi;
    SmsEndpoint smsEndpoint;
    private RecyclerView recyclerView;
    private AdapterListInbox mAdapter;
    private ActionModeCallback actionModeCallback;
    private androidx.appcompat.view.ActionMode actionMode;
    private Toolbar toolbar;
    private List<Inbox> items = new ArrayList<>();
    private FloatingActionButton fab_Load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovar_resultado);

        initToolbar();

        Toast.makeText(this, "Long press for multi selection", Toast.LENGTH_SHORT).show();
        FirebaseClient firebaseClient = new FirebaseClient();
        firebaseClient.customObjects(this);
        initComponent();
        smsEndpoint = SMSAPI.getSenaiteEndpoint(this);

    }


    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inbox");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void addItems(List<ItemResult> itemResults) {

        items.clear();
        int x = 1;
        for (ItemResult ir : itemResults) {

            items.add(new Inbox(x, null, ir.getName(), ir.getPhone(), "", "", R.color.red_500));
        }

/*
        items.clear();
        items.add(new Inbox(1,R.drawable.photo_female_1, "Marcia Reyes","marciareyes@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(2,R.drawable.photo_female_2, "Mery Lopez","merylopezs@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(3,R.drawable.photo_female_3, "Mariana Perez","mperezs@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(4,R.drawable.photo_male_1, "Jorge Ruiz","jruizs@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(5,R.drawable.photo_male_2, "Marco Mendez","marcoperez@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(6,R.drawable.photo_male_3, "Luis Ramirez","lramirezs@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
        items.add(new Inbox(7,null, "Linda Martinez","lindams@gmail.com","es simplemente el texto de relleno de las imprentas y archivos de texto","18 Nov.2018", R.color.red_500));
*/


        mAdapter.notifyDataSetChanged();
    }

    private void initComponent() {
        fab_Load = findViewById(R.id.fab_refresh);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //set data and list adapter
        mAdapter = new AdapterListInbox(this, items);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new AdapterListInbox.OnClickListener() {
            @Override
            public void onItemClick(View view, Inbox obj, int pos) {
                if (mAdapter.getSelectedItemCount() > 0) {
                    enableActionMode(pos);
                } else {
                    // read the inbox which removes bold from the row
                    Inbox inbox = mAdapter.getItem(pos);
                    Toast.makeText(getApplicationContext(), "Read: " + inbox.from, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClick(View view, Inbox obj, int pos) {
                enableActionMode(pos);
            }
        });

        //when fab was used for refreshing
        /*fab_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItems(itemResultList);
            }
        });*/
        fab_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessagesThroughMensageiro(itemResultList);
            }
        });


        actionModeCallback = new ActionModeCallback();

    }

    private void sendMessagesThroughMensageiro(List<ItemResult> itemResultList) {
        Message message = new Message();
        message.setUrns(new ArrayList<String>());
        for (ItemResult itemResult : itemResultList) {
            message.getUrns().add("tel:" + itemResult.getPhone());

        }
        message.setText("Estimado utente, o seu resultado ja esta pronto. Queira por favor dirigir-se ao HCB para levantamento.");
        Call<SendSmsResponse> call = smsEndpoint.sendSms(message);
        //System.out.println("Token: "+ token);
        //itemResultList = new ArrayList<>();
        call.enqueue(new Callback<SendSmsResponse>() {
            @Override
            public void onResponse(Call<SendSmsResponse> call, Response<SendSmsResponse> response) {
                int statusCode = response.code();
                System.out.println(statusCode);
                Log.d(TAG, "Message sucess?");
                Log.d(TAG, "onResponse: " + response.body());

            /*    AnalysisRequestList arl = response.body();
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
                //res = ar.getItems();*/


            }

            @Override
            public void onFailure(Call<SendSmsResponse> call, Throwable t) {
                t.printStackTrace();
            }

        });
        System.out.println("Result List Size" + itemResultList.size());
        //return itemResultList;


    }

    private void enableActionMode(int position) {
        if (actionMode == null) {
            //actionMode = startSupportActionMode(actionModeCallback);
        }
        toggleSelection(position);
    }


    private void toggleSelection(int position) {
        mAdapter.toggleSelection(position);
        int count = mAdapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
    }

    @Override
    public void onCustomObject(List<ItemResult> itemResults) {

        itemResultList = itemResults;
        addItems(itemResultList);

    }

    private void deleteInboxes() {
        List<Integer> selectedItemPositions = mAdapter.getSelectedItems();
        for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
            mAdapter.removeData(selectedItemPositions.get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private class ActionModeCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Tools.setSystemBarColor(NotificationsPendentes.this, R.color.colorDarkBlue2);
            mode.getMenuInflater().inflate(R.menu.menu_delete, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_delete) {
                deleteInboxes();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mAdapter.clearSelections();
            actionMode = null;
            Tools.setSystemBarColor(NotificationsPendentes.this, R.color.colorPrimary);
        }
    }
}