package com.example.duvangiraldo.reciclame;

import java.util.ArrayList;

/**
 * Created by Duvan Giraldo on 24/05/2017.
 */

public class ManejoDedatos {
    public static ArrayList<String> vocero = new ArrayList<String>();
    public static ArrayList<String> categoria= new ArrayList<String>();
    public static ArrayList<String> direccion = new ArrayList<String>();

    private static final ManejoDedatos INSTANCE = new ManejoDedatos();



    public ManejoDedatos(){
    }


    public static ManejoDedatos getInstance(){
        return INSTANCE;
    }

    public static ArrayList<String> ObtenerListaVocero() {
        return vocero;
    }

    public static ArrayList<String> ObtenerListaCategoria() {
        return categoria;
    }

    public static ArrayList<String> ObtenerListaDireccion() {
        return direccion;
    }

    public void SetearValores(String mVocero,String mCategoria,String mDireccion) {
        vocero.add(mVocero);
        categoria.add(mCategoria);
        direccion.add(mDireccion);
    }
}
