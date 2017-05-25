package com.example.duvangiraldo.reciclame;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boton_sig = (Button) findViewById(R.id.boton_sig);

        boton_sig.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Mostrar_puntos.class  );
                startActivityForResult(intent, 0); }
        });




    }





    }






