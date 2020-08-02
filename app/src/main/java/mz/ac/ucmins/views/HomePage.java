package mz.ac.ucmins.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import mz.ac.ucmins.Model.LoginResponse;
import co.mz.ucmins.R;

public class HomePage extends AppCompatActivity {
 private TextView userName;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //check SDK version from the users Device


        userName = findViewById(R.id.username);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String username = (String) extras.get("username");
            LoginResponse.Item user = (LoginResponse.Item) extras.get("user");
            userName.setText(username);
            System.out.println(user.getRoles().contains("Manager"));
            if(user.getRoles().contains("Manager")){

                FirebaseMessaging.getInstance().subscribeToTopic("weather")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                String msg = getString(R.string.msg_subscribed);
                                if (!task.isSuccessful()) {
                                    msg = getString(R.string.msg_subscribe_failed);
                                }
                                Log.d(TAG, msg);
                                Toast.makeText(HomePage.this, msg, Toast.LENGTH_SHORT).show();

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
                                Toast.makeText(HomePage.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                // [END retrieve_current_token]
            }
        }else {
            userName.setText("Nome do Usuario");
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
}
