package co.mz.ins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 private Handler handler;
 private Runnable runnable;
 private ImageView splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash= findViewById(R.id.logotipo);
        splash.animate().alpha(4000).setDuration(0);

        handler= new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(MainActivity.this,LoginPage.class);
                startActivity(dsp);
                finish();
            }
        }, 4000);
    }
}
