package co.mz.ins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void resultados(View view) {
        Intent entrar = new Intent(this, ResultsPageContainer.class);
        startActivity(entrar);
    }

    public void aprovar(View view) {
        Intent entrar = new Intent(this, AprovarResultado.class);
        startActivity(entrar);
    }
}