package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class Vitoria_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitoria_activity);
    }
    public void bntContinuar(View view){
        Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
        startActivity(intent);

        finish();
    }

    public void btnSair(View view){
        finish();
    }
}
