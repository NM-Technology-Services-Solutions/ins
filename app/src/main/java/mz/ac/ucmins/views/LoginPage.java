package mz.ac.ucmins.views;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import mz.ac.ucmins.Adapters.FingerPrintHandler;
import mz.ac.ucmins.Model.LoginResponse;
import co.mz.ucmins.R;
import mz.ac.ucmins.api.ApiUtils;
import mz.ac.ucmins.api.SenaiteEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPage extends AppCompatActivity {
    private TextView mHeadingLabel;
    private ImageView mFingerprintImage;
    private ImageView icon;
    private Button btnEntar;
    private TextView mTextImpressao;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    private Animation topAnim;
    private Animation bottomAnim;

    TextInputEditText edtUsername;
    TextInputEditText edtPassword;

    Button btnLogin;
    SenaiteEndpoint userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);

        mFingerprintImage = (ImageView) findViewById(R.id.fingerPrint);
        mTextImpressao = (TextView) findViewById(R.id.textoFinger);
        icon = (ImageView) findViewById(R.id.icon);

        //Animacao dos dois items
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        icon.setAnimation(topAnim);
        mFingerprintImage.setAnimation(bottomAnim); //fim

        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);
        userService = new ApiUtils().getSenaiteEndpoint(this, getString(R.string.apibaseurl));


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //Intent intent = new Intent(LoginPage.this, HomePage.class);
                //startActivity(intent);
                //validate form
               if (validateLogin(username, password)) {
                    //do login
                    System.out.println("kkkkkkkkk");
                    doLogin(username, password);
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            if (!fingerprintManager.isHardwareDetected()) {
                mTextImpressao.setText("Não Detectado FingerPrint No Despositivo");
            } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                mTextImpressao.setText("Permissão não Concedida");
            } else if (!keyguardManager.isKeyguardSecure()) {
                mTextImpressao.setText("Segurança");
            } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                mTextImpressao.setText("Adiciona pelo menos uma impressão digital");
            } else {
                mTextImpressao.setText("Coloque o dedo");
                FingerPrintHandler fingerPrintHandler = new FingerPrintHandler(this);
                fingerPrintHandler.starAuth(fingerprintManager, null);
            }
        }

    }

    private void doLogin(String username, String password) {

        Call<LoginResponse> call = userService.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse resObj = response.body();
                    if (resObj.getItems().get(0).isAuthenticated()) {
                        //login start main activity
                        Intent intent = new Intent(LoginPage.this, HomePage.class);
                        intent.putExtra("username", resObj.getItems().get(0).username);
                        intent.putExtra("user",resObj.getItems().get(0) );


                        System.out.println(resObj.getItems().get(0).username);

                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginPage.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginPage.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginPage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateLogin(String username, String password) {

        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void login(View view) {
        Intent entrar = new Intent(this, HomePage.class);
        startActivity(entrar);
    }
}