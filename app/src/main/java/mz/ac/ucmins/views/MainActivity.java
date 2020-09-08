package mz.ac.ucmins.views;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import co.mz.ucmins.R;
import mz.ac.ucmins.Model.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ".MainActivity";
    private Handler handler;
    private Runnable runnable;
    private ImageView splash;
    private TextView textView;
    private Animation topAnim;
    private Animation bottomAnim;
    private FirebaseAuth mAuth;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            String channelId  = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_HIGH));
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        splash= findViewById(R.id.logotipo);
        textView = findViewById(R.id.desenvolvido);
        //preferences
        preferences = getApplicationContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        editor = preferences.edit();

        //splash.animate().alpha(4000).setDuration(0);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        splash.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);

        mAuth = FirebaseAuth.getInstance();

/*        handler= new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(MainActivity.this,LoginPage.class);
                startActivity(dsp);
                finish();
            }
        }, 6000);*/
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //user = new User();
        showHomeUI(currentUser);

    }
    // [END on_start_check_user]

    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(mTokenReceiver, TokenBroadcastReceiver.getFilter());
    }


    @Override
    protected void onPause() {
        super.onPause();
       // unregisterReceiver(mTokenReceiver);
    }


    private void showHomeUI(FirebaseUser user) {
        //showLogin();
        if (user != null) {
            Log.d(TAG, "ShowHomwUI: firebase user not Null");
            if (preferences.getString("LoginPref", "nopref").equals("nopref")) {
                Log.d(TAG, "ShowHomeUI: Login Pref does not exists");
                showLogin();
            } else {
                Log.d(TAG, "ShowHomeUI: Both Login Pref and Firebase User exists ");
                showHome(user);
            }
        } else {
            Log.d(TAG, "ShowHomwUI: firebase user is Null");
            showLogin();
        }
    }

    private void showHome(FirebaseUser user) {
        Log.d(TAG, "showHome: preparing to login");
        handler = new Handler();

        Log.d(TAG, "showHome: the current prefs are " + preferences.getAll());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(MainActivity.this, HomePage.class);
                startActivity(dsp);
                finish();
            }
        }, 3000);

    }

    private void showLogin() {
        Log.d(TAG, "showLogin: called");
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(MainActivity.this, LoginPage.class);
                startActivity(dsp);
                finish();
            }
        }, 3000);
    }

    private boolean isServerConfigOk() {


        return true;

    }


}
