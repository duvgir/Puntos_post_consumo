package com.example.duvangiraldo.reciclame;

/**
 * Created by Duvan Giraldo on 24/05/2017.
 */
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


public class BasedeDatos  extends SQLiteOpenHelper {


    private  static String DB_PATH = "/data/data/com.duvangiraldo.Reciclame/databases/";
    private static String DB_NAME = "puntos_pstConsumo.db";

    private static SQLiteDatabase mDataBase;

    private static BasedeDatos sInstance = null;

    private static final int DATABASE_VERSION = 1;


    public BasedeDatos() {


        super(Mostrar_puntos.activity, DB_NAME, null, DATABASE_VERSION);

        try {
            createDataBase();
            openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static BasedeDatos instance() {

        if (sInstance == null) {
            sInstance = new BasedeDatos();
        }
        return sInstance;
    }


    private void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();
        SQLiteDatabase db_Read = null;

        if (dbExist) {
            // la base de datos ya existe
        } else {

            db_Read = this.getReadableDatabase();
            db_Read.close();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copiando base de datos");
            }
        }
    }

    public boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    public void copyDataBase() throws IOException {

        InputStream myInput = Mostrar_puntos.activity.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private void openDataBase() throws SQLException {

        String myPath = DB_PATH + DB_NAME;
        mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }


    public Cursor select(String query) throws SQLException {
        return mDataBase.rawQuery(query, null);
    }




    public synchronized void close() {

        if (mDataBase != null)
            mDataBase.close();

        mDataBase.close();

    }


    public void onCreate(SQLiteDatabase db) {

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}


