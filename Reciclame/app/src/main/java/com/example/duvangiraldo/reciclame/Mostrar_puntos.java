package com.example.duvangiraldo.reciclame;

import java.io.InputStream;
import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListAdapter;
import android.widget.ListView;;

public class Mostrar_puntos extends AppCompatActivity {

    private ListView listView;
    private Datos itemArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_puntos);
        itemArrayAdapter = new Datos(getApplicationContext(), R.layout.item_layout);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter((ListAdapter) itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.puntos);
        LectorCSV csvFile = new LectorCSV(inputStream);
        List<String[]> scoreList = csvFile.read();

        for(String[] scoreData:scoreList ) {
            itemArrayAdapter.add(scoreData);
        }
    }
}


