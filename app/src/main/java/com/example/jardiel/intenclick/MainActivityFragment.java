package com.example.jardiel.intenclick;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ArrayList<Clima> listaClima = new ArrayList<Clima>();
        listaClima.add(new Clima("lunes", "Soleado","33°/28°", R.drawable.soleado));
        listaClima.add(new Clima("martes", "nublado","33°/28°", R.drawable.nublado));
        listaClima.add(new Clima("Miercoles", "tormenta","33°/28°", R.drawable.tormenta));
        listaClima.add(new Clima("Jueves", "lluvioso","33°/28°", R.drawable.lluvia));
        listaClima.add(new Clima("Viernes", "nublado","33°/28°", R.drawable.nublado));

        List<Clima> lista = (List) listaClima;

        ClimaAdapter climaAdapter = new ClimaAdapter(getActivity(), R.layout.list_item_forecast, lista);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item_forecast);
        listView.setAdapter(climaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Clima clima = listaClima.get(position);

                Intent intent = new Intent(getActivity(), WeatherActivity.class);
                intent.putExtra("clima", clima);
                startActivity(intent);

            }
        });

        return rootView;
    }
}
