package com.nastala.sihirlisayilar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nastala.sihirlisayilar.Fragments.SihirliKartFragment;
import com.nastala.sihirlisayilar.Fragments.SihirliSayilarFragment;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MAINACTIVITY";

    Button btnSihirliSayilar, btnSihirliKart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSihirliSayilar = findViewById(R.id.btnSihirliSayilar);
        btnSihirliKart = findViewById(R.id.btnSihirliKart);

        btnSihirliSayilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.flMain, new SihirliSayilarFragment()).addToBackStack(null).commit();
            }
        });

        btnSihirliKart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.flMain, new SihirliKartFragment()).addToBackStack(null).commit();
            }
        });
    }
}
