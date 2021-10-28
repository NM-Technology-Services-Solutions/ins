package mz.ac.ucmins.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.preference.PreferenceManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import co.mz.ucmins.R;
import mz.ac.ucmins.Model.LoginResponse;
import mz.ac.ucmins.Model.User;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {
    private static final String TAG = ".HomePage";
    public static boolean isAppRunning;
    private TextView userName;
    private SharedPreferences preferences;
    private SenaiteEndpoint userService;
    //Gson gson;
    User user;

    CardView verNotificacoesPendentesCardView;
    CardView verificarResultadosCardView;
    CardView verSolicitacoesPendentesView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        verNotificacoesPendentesCardView = findViewById(R.id.verNotificacoesPendentesID);
        verificarResultadosCardView=findViewById(R.id.aprovarResultadosID);
        verSolicitacoesPendentesView=findViewById(R.id.verSolicitacoesPendentesID);
        setSupportActionBar(toolbar);
        preferences = getApplicationContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        userService = ApiUtils.getSenaiteEndpoint(this);
        //check SDK version from the users Device

        Log.d(TAG, "onCreate: current login preferences are: " + preferences.getAll());
       Gson gson = new Gson();
        String json = preferences.getString("LoginPref", "");
         //user = gson.fromJson(json, User.class);

        //fortest start here
        user= new User();
        user.setUsername("Tilson");
        List<String> roles2 = new ArrayList<>();
        roles2.add("LabManager");
        user.setRoles(roles2);
        //fortest ends here
        userName = findViewById(R.id.username);
        Bundle extras = getIntent().getExtras();

        doLogin(preferences.getString("username","nill"),preferences.getString("password","nill"));

        subscribeToChanel();
toggleButtons();

        // Sets default values only once, first time this is called.
        // The third argument is a boolean that indicates whether
        // the default values should be set more than once. When false,
        // the system sets the default values only if this method has never
        // been called in the past.
        PreferenceManager
                .setDefaultValues(this,
                        R.xml.preferences, false);

        // Read the settings from the shared preferences, put them into the
        // SettingsActivity, and display a toast.
        SharedPreferences sharedPref =
                PreferenceManager
                        .getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                (SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false);
        Toast.makeText(this, switchPref.toString(),
                Toast.LENGTH_SHORT).show();
    }

    private void subscribeToChanel() {
        Log.d(TAG, "subscribeToChanel: Attempting to subscribe to FCM channel");
        if (preferences.contains("LoginPref")) {


            System.out.println(user.getRoles().contains("Manager"));
            userName.setText(user.getUsername());
            if (user.getRoles().contains("LabManager")) {

                FirebaseMessaging.getInstance().subscribeToTopic("weather")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                String msg = getString(R.string.msg_subscribed);
                                if (!task.isSuccessful()) {
                                    msg = getString(R.string.msg_subscribe_failed);
                                }
                                Log.d(TAG, msg);
                            }
                        });
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "getInstanceId failed", task.getException());
                                    return;
                                }
                                // Get new Instance ID token
                                String token = task.getResult().getToken();

                                // Log and toast
                                String msg = getString(R.string.msg_token_fmt, token);
                                Log.d(TAG, msg);
                            }
                        });
                // [END retrieve_current_token]
            }
        }else {
            userName.setText(user.username);
        }
    }


    public void resultados(View view) {
        Intent entrar = new Intent(this, ResultsPageContainer.class);
        Bundle extras = getIntent().getExtras();

        startActivity(entrar);
    }

    public void aprovar(View view) {
        Intent entrar = new Intent(this, AprovarResultado.class);
        startActivity(entrar);
    }

    public void riquisitarScreen(View view) {

        Intent entrar = new Intent(this, RequestAmostra.class);
        startActivity(entrar);
    }

    public void verNotificacoesPendentes(View view) {
        Intent entrar = new Intent(this, NotificationsPendentes.class);
        startActivity(entrar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            startActivity(new Intent(HomePage.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doLogin(final String username, final String password) {

        Call<LoginResponse> call = userService.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse resObj = response.body();
                    User user = resObj.getItems().get(0);
                    if (resObj.getItems().get(0).isAuthenticated()) {
                        Gson gson = new Gson();
                        String json = gson.toJson(user);


                    } else {
                        Toast.makeText(HomePage.this, "Falha ao Autenticar no SENAITE", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(HomePage.this, "Error! Please  try again!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(LoginPage.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(HomePage.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(HomePage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(LoginPage.this, call.request().url().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }


    public void toggleButtons(){

        if (!user.getRoles().contains("LabManager")) {
            verNotificacoesPendentesCardView.setFocusable(false);
            verNotificacoesPendentesCardView.setCardBackgroundColor(Color.GRAY);
            verNotificacoesPendentesCardView.setClickable(false);

            verificarResultadosCardView.setFocusable(false);
            verificarResultadosCardView.setClickable(false);
            verificarResultadosCardView.setCardBackgroundColor(Color.GRAY);

            verSolicitacoesPendentesView.setFocusable(false);
            verSolicitacoesPendentesView.setClickable(false);
            verSolicitacoesPendentesView.setCardBackgroundColor(Color.GRAY);
        }
    }

}
