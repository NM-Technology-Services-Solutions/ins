package co.mz.ins;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RequestAmostra extends AppCompatActivity {
private TextInputEditText editText;

    ImageView amostra_backArrow_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_amostra);

        amostra_backArrow_btn = findViewById(R.id.amostra_backArrow_btn);
        editText = findViewById(R.id.codigoAmostra);

    }

    public void backHome(View view) {
        Intent intent = new Intent(getApplicationContext(), HomePage.class);

        //Adding transiction between screens

        Pair [] pairs = new Pair[1];

        pairs[0] = new Pair <View,String>(amostra_backArrow_btn, "trans_back_arrow_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RequestAmostra.this, pairs);

        startActivity(intent, options.toBundle());

    }

    public void procurar(View view) {
        String code = editText.getText().toString();
        if (code.equals("12345")){
            Intent intent = new Intent(getApplicationContext(), AmostraSearchResult.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getApplicationContext(), NotFoundAmostra.class);
            startActivity(intent);
        }

    }
}