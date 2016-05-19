package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller.ClsArea;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.MainActivity;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo.Area;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.R;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.RestClient.VolleyS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentArea  extends Fragment {
    ListView lvElegirArea;
    Area a;
    static private VolleyS volley;
    static protected RequestQueue fRequestQueue;
    ClsArea ca;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragmentarea, container, false);
        lvElegirArea=(ListView)view.findViewById(R.id.LvArea);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("AREA");
        String[] columnas = new String[]{"nombre_area"};
        int[] id_views = new int[]{android.R.id.text1};
        Cursor cursora=ca.ReadArea();
        SimpleCursorAdapter adaptador = new android.support.v4.widget.SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_2, cursora, columnas, id_views);
        lvElegirArea.setAdapter(adaptador);

        return view;

    }
}

