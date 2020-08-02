package mz.ac.ucmins.Adapters;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import co.mz.ucmins.R;

public class FingerPrintHandler extends FingerprintManager.AuthenticationCallback {
    private Context context;

    public FingerPrintHandler(Context context){
        this.context=context;
    }
    public void starAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){
        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("Houve um erro."+errString, false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Autenticação Falhou", false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Tente novamente", false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("Permissão Concedida", true);

    }

    private void update(String s, boolean b) {
        TextView textView = ((Activity)context).findViewById(R.id.textoFinger);
        ImageView imageView = ((Activity)context).findViewById(R.id.fingerPrint);
        textView.setText(s);

        if (b == false){
           textView.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
        }else {
            textView.setTextColor(ContextCompat.getColor(context,R.color.splash_color));
            imageView.setImageResource(R.drawable.fingerdone);
            //Intent intent = new Intent(context, HomePage.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //context.startActivity(intent);
        }
    }
}
