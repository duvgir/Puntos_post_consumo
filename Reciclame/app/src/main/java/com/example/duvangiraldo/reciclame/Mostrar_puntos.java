package com.example.duvangiraldo.reciclame;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.SQLException;

public class Mostrar_puntos extends AppCompatActivity {


    public static Activity activity;
    BasedeDatos manejadorBD;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_puntos);

        activity = this;
        manejadorBD = BasedeDatos.instance();

        Cursor cursor = null;
        try {
            cursor = manejadorBD.select("SELECT vocero,categoria,deireccion" +
                    " FROM Puntos_Postconsumo WHERE codigomunicipio=" + "05001");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (cursor.moveToNext())

            ManejoDedatos.getInstance().SetearValores(
                    cursor.getString(cursor.getColumnIndex("vocero")),
                    cursor.getString(cursor.getColumnIndex("categoria")),
                    cursor.getString(cursor.getColumnIndex("deireccion")));

        cursor.close();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



    }

    public void LlenarLista(View v) {
        final ArrayAdapter<String> vocerosAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, ManejoDedatos.ObtenerListaVocero());

        ((ListView) findViewById(R.id.lv_vocero)).setAdapter(vocerosAdapter);


        final ArrayAdapter<String> categoriaAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, ManejoDedatos.ObtenerListaCategoria());

        ((ListView) findViewById(R.id.lv_categoria)).setAdapter(categoriaAdapter);

        final ArrayAdapter<String> direccionAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, ManejoDedatos.ObtenerListaDireccion());

        ((ListView) findViewById(R.id.lv_direccion)).setAdapter(direccionAdapter);
    }


    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/


    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

