package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller;

import android.content.Context;
import android.database.Cursor;

import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Config.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Luis Lavado on 18/05/2016.
 */
public class ClsPersona {
    SQLite cx;
    String query;
    public ClsPersona(Context context) {
        cx = new SQLite(context);
    }

    public void insert_Persona(JSONArray jsonArray) {
        try {
            cx.getWritableDatabase().execSQL("DELETE FROM persona");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                cx.getWritableDatabase().execSQL("INSERT INTO  persona ( nombres , apepat , apemat , genero , dni , fecha_nac , telefono_propio , ruc ," +
                " direccion , codigo , foto_persona , estado ) VALUES ('"+ jo.getString("nombres")+"','"+ jo.getString("apepat")+"','"+ jo.getString("apemat")+"'," +
                " '"+ jo.getString("genero")+"','"+ jo.getString("dni")+"','"+ jo.getString("fecha_nac")+"','"+ jo.getString("telefono_propio")+"','"+ jo.getString("ruc")+"'," +
                        " '"+ jo.getString("direccion")+"','"+ jo.getString("codigo")+"','"+ jo.getString("foto_persona")+"','"+ jo.getString("estado")+"')");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Cursor ReadPersona(){
        return cx.getWritableDatabase().rawQuery("SELECT id_persona as _id, nombres , apepat , apemat , genero , dni , fecha_nac , telefono_propio , ruc , direccion , codigo , foto_persona , estado  FROM persona ",null);
    }
}
