package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luis Lavado on 11/05/2016.
 */
public class SQLite extends SQLiteOpenHelper {

    private static String NAME_DATABASE = "agenda";
    private static int VERSION=1;
    //private static SQLiteDatabase.CursorFactory factory=null;

    private String TB_AREA ="CREATE TABLE area " +
            "(id_area INTEGER PRIMARY KEY, " +
            " nombre_area TEXT, " +
            " estado TEXT, "+
            " id_area_padre INTEGER, "+
            " id_empresa INTEGER, "+
            " FOREIGN KEY(id_area_padre) REFERENCES area(id_area), " +
            " FOREIGN KEY(id_empresa) REFERENCES empresa(id_empresa))";

    private String TB_PERSONA ="CREATE TABLE persona " +
            "(id_persona INTEGER PRIMARY KEY AUTOINCREMENT , " +
            " nombres TEXT, " +
            " apepat TEXT, " +
            " apemat TEXT, " +
            " genero TEXT, "+
            " dni TEXT, "+
            " fecha_nac DATE, "+
            " telefono_propio TEXT, "+
            " ruc TEXT, "+
            " direccion TEXT, "+
            " codigo TEXT, "+
            " foto_persona BLOB, "+ //BLOB para archivos (fotos, entre otros)
            " estado TEXT)";

    public SQLite(Context c) {
        super(c, NAME_DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TB_AREA);
        db.execSQL(TB_PERSONA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS area");
        db.execSQL("DROP TABLE IF EXISTS persona");
        this.onCreate(db);
    }
}
