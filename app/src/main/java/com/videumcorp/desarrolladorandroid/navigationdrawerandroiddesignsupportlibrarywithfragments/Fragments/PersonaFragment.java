package com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller.ClsArea;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Controller.ClsPersona;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.MainActivity;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo.Area;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.Modelo.Persona;
import com.videumcorp.desarrolladorandroid.navigationdrawerandroiddesignsupportlibrarywithfragments.R;


public class PersonaFragment extends Fragment {
    ListView persona;
    ClsPersona cp;
    Persona p;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    cp=new ClsPersona(getActivity());
     p=new Persona();
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragmentarea, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("PERSONA");
        persona=(ListView)v.findViewById(R.id.LvPersona);
        String[] columnas = new String[]{"nombres","apepat"};
        int[] id_views = new int[]{android.R.id.text1,android.R.id.text2};
        Cursor cursorp=cp.ReadPersona();
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_2, cursorp, columnas, id_views);
        persona.setAdapter(adaptador);


        return v;
    }

}
