package mz.ac.ucmins.views;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import co.mz.ucmins.R;
import mz.ac.ucmins.Adapters.FingerPrintHandler;
import mz.ac.ucmins.Model.LoginResponse;
import mz.ac.ucmins.Model.User;
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
    SharedPreferences preferences ;
    SharedPreferences.Editor editor ;

    private FirebaseAuth mAuth;
    private static final String TAG = "CustomAuthActivity";


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
        userService = ApiUtils.getSenaiteEndpoint(this);

        //preferences
        preferences = getApplicationContext().getSharedPreferences("LoginPref", MODE_PRIVATE);
        editor = preferences.edit();

        //Firebase Authentication and Authorizations
        mAuth= FirebaseAuth.getInstance();



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
            if (fingerprintManager == null) {
                mTextImpressao.setText("Não Detectado FingerPrint No Despositivo");
            } else if (!fingerprintManager.isHardwareDetected()) {
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

    private void doLogin(final String username, final String password) {

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

                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putString("LoginPref", json);
                        editor.commit();
                        //login start main activity
                        Intent intent = new Intent(LoginPage.this, HomePage.class);
                        intent.putExtra("username", user);
                        //intent.putExtra("user",resObj.getItems().get(0) );


                        //System.out.println(user.getUsername());
                        // System.out.println(user.toString());
                        /*FirebaseUser currentUser = mAuth.getCurrentUser();
                        if(currentUser!=null){
                            System.out.println("user registered before: " +currentUser.getUid());
                        }
                        startFirebaseLogin(user,password);
*/
                        startFirebaseLogin(user, password);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginPage.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginPage.this, "Error! Please  try again!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(LoginPage.this, response.message(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginPage.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginPage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(LoginPage.this, call.request().url().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginPage.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startFirebaseLogin(final User user, final String password) {
        // [START sign_in_custom]
        System.out.println(user);


        mAuth.signInWithEmailAndPassword(user.getEmail(),password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success");
                            System.out.println("Ja temos solucao");
                            FirebaseUser user = mAuth.getCurrentUser();
                            doLogin(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                            createAccount(user.getEmail(),password);
                        }
                    }
                });
        /* [END sign_in_custom] */
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

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);


        //showProgressBar();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            doLogin(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        doLogin(currentUser);
    }

    private void doLogin(FirebaseUser user) {
            if (user != null) {

                System.out.println("registred to firebase: " + user.getUid());

            } else {

                //registerToFirebase();

            }

    }

    private void registerToFirebase(){
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (validateLogin(username, password)) {
            //do login
            System.out.println("Email e Password Prontos pra Firebase");

            //showProgressBar();

            // [START create_user_with_email]
            mAuth.createUserWithEmailAndPassword(username+"", password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //doLogin(user);
                                System.out.println("User created and registered: " + user.getUid());
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",  Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // [START_EXCLUDE]
                            //hideProgressBar();
                            // [END_EXCLUDE]
                        }
                    });

        }
    }

}