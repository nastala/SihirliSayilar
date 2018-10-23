package com.nastala.sihirlisayilar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MAINACTIVITY";

    private EditText etGirilenSayi;
    private Button btnHesapla;
    private TextView tvMesaj1, tvMesaj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGirilenSayi = findViewById(R.id.etGirilenSayi);
        btnHesapla = findViewById(R.id.btnHesapla);
        tvMesaj1 = findViewById(R.id.tvMesaj1);
        tvMesaj2 = findViewById(R.id.tvMesaj2);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla(etGirilenSayi.getText().toString());
            }
        });
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
