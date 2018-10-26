package com.nastala.sihirlisayilar.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.nastala.sihirlisayilar.Adapters.AdapterGVSihirliKartlar;
import com.nastala.sihirlisayilar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SihirliKartFragment extends Fragment {
    private GridView gvSihirliKartlar;

    public SihirliKartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sihirli_kart, container, false);

        gvSihirliKartlar = view.findViewById(R.id.gvSihirliKartlar);
        AdapterGVSihirliKartlar adapter = new AdapterGVSihirliKartlar(getActivity());
        gvSihirliKartlar.setAdapter(adapter);

        return view;
    }

}
