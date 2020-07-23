package co.mz.ins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
 private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userName = findViewById(R.id.username);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String username = (String) extras.get("username");
            userName.setText(username);
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
