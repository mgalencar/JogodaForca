package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 17259222 on 27/08/2018.
 */

public class Inicio_Activity extends Activity {

    ImageView img_forca;
    Button  btn_inicio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);

    }

    public void btnIniciar(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);

        finish();
    }
}
