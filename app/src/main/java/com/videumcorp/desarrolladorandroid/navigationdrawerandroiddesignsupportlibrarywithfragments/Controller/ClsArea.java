package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller;

import android.content.Context;
import android.database.Cursor;

import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Config.SQLite;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo.Area;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by Luis Lavado on 18/05/2016.
 */
public class ClsArea {
    SQLite cx;
    String query;
    public ClsArea(Context context) {
        cx = new SQLite(context);
    }

    public void insert_Area(JSONArray jsonArray) {
        try {
            cx.getWritableDatabase().execSQL("DELETE FROM area");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                cx.getWritableDatabase().execSQL("INSERT INTO area (nombre_area,estado,id_area_padre,id_empresa) " +
                        "VALUES ('"+ jo.getString("nombre_area")+"' , '"+ jo.getString("estado")+"' , "+ jo.getInt("id_area_padre")+" , "+ jo.getInt("id_empresa")+")");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Cursor ReadArea(){
        return cx.getWritableDatabase().rawQuery("SELECT id_area as _id, nombre_area, estado, id_area_padre, id_empresa FROM area",null);
    }
}
