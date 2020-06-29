package co.mz.ins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.mz.ins.Adapters.FingerPrintHandler;

public class LoginPage extends AppCompatActivity {
     private TextView mHeadingLabel;
     private ImageView mFingerprintImage;
     private Button btnEntar;
     private  TextView mTextImpressao;
     private FingerprintManager fingerprintManager;
     private KeyguardManager keyguardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mFingerprintImage = (ImageView) findViewById(R.id.fingerPrint);
        mTextImpressao = (TextView) findViewById(R.id.textoFinger);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
             fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
             keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

             if(!fingerprintManager.isHardwareDetected()){
                mTextImpressao.setText("Não Detectado FingerPrint No Despositivo");
             } else if(ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                 mTextImpressao.setText("Permissão não Concedida");
             }else if(!keyguardManager.isKeyguardSecure()){
                 mTextImpressao.setText("Segurança");
             } else if(!fingerprintManager.hasEnrolledFingerprints()){
                 mTextImpressao.setText("Adiciona pelo menos uma impressão digital");
             } else {
                 mTextImpressao.setText("Coloque o dedo");
                 FingerPrintHandler fingerPrintHandler = new FingerPrintHandler(this);
                 fingerPrintHandler.starAuth(fingerprintManager,null);
             }
        }

    }

    public void login(View view) {
        Intent entrar = new Intent(this, HomePage.class);
        startActivity(entrar);
    }
}