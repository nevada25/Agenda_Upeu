package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Fragments;

import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller.ClsArea;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.MainActivity;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo.Area;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.R;


public class AreaFragment extends Fragment {
    ListView area;
    ClsArea ca;
    Area a;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
ca=new ClsArea(getActivity());
        a=new Area();
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragmentarea, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("AREA");
        area=(ListView)v.findViewById(R.id.LvArea);
        String[] columnas = new String[]{"nombre_area"};
        int[] id_views = new int[]{android.R.id.text1};
        Cursor cursora=ca.ReadArea();
        SimpleCursorAdapter adaptador = new android.support.v4.widget.SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_2, cursora, columnas, id_views);
        area.setAdapter(adaptador);


        return v;
    }

}
