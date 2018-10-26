package com.nastala.sihirlisayilar.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nastala.sihirlisayilar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SihirliSayilarFragment extends Fragment {
    private final String TAG = "FRAG_SIHIRLISAYILAR";

    private EditText etGirilenSayi;
    private Button btnHesapla;
    private TextView tvMesaj1, tvMesaj2;

    public SihirliSayilarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sihirli_sayilar, container, false);

        etGirilenSayi = view.findViewById(R.id.etGirilenSayi);
        btnHesapla = view.findViewById(R.id.btnHesapla);
        tvMesaj1 = view.findViewById(R.id.tvMesaj1);
        tvMesaj2 = view.findViewById(R.id.tvMesaj2);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla(etGirilenSayi.getText().toString());
            }
        });

        return view;
    }

    private void hesapla(String girilenSayi){
        double sayi;

        try {
            sayi = Double.parseDouble(girilenSayi);
        }
        catch (Exception e){
            Log.d(TAG, "ParseException " + e.getMessage());
            return;
        }

        double kuvvet = 0;
        double geciciSayi = 1;
        double kalan = sayi;
        String mesaj1 = String.format("%.0f = ", sayi);
        String mesaj2 = String.format("%.0f = ", sayi);

        while (kalan > 0){
            while (geciciSayi <= kalan){
                kuvvet++;
                geciciSayi = Math.pow(2, kuvvet);
            }

            geciciSayi = Math.pow(2, --kuvvet);
            kalan -= geciciSayi;
            mesaj1 += String.format("%.0f", geciciSayi) + " + ";
            mesaj2 += "2<sup>" + (int)kuvvet + "</sup> + ";

            geciciSayi = 1;
            kuvvet = 0;
        }

        mesaj1 = mesaj1.substring(0, mesaj1.length() - 2);
        mesaj2 = mesaj2.substring(0, mesaj2.length() - 2);

        tvMesaj1.setText(mesaj1);
        tvMesaj2.setText(Html.fromHtml(mesaj2));
    }
}
