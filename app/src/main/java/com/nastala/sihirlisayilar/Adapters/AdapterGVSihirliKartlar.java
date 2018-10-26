package com.nastala.sihirlisayilar.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.nastala.sihirlisayilar.Classes.Sayi;
import com.nastala.sihirlisayilar.R;
import java.util.ArrayList;

public class AdapterGVSihirliKartlar extends BaseAdapter {
    private ArrayList<Sayi> sayilar;
    private Activity activity;

    public AdapterGVSihirliKartlar(Activity activity){
        this.activity = activity;
        sayilar = new ArrayList<>();
        sayilariDoldur();
    }

    @Override
    public int getCount() {
        return sayilar.size();
    }

    @Override
    public Object getItem(int position) {
        return sayilar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = ((LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.adapter_gvsihirlikartlar, parent, false);

        GridView gvSihirliKartItem = convertView.findViewById(R.id.gvSihirliKartItem);
        AdapterGVSihirliKartItem adapter = new AdapterGVSihirliKartItem(activity, sayilar.get(position).getSayilar());
        gvSihirliKartItem.setAdapter(adapter);

        Log.d("ADAPTERGV", sayilar.size() + " position: " + position);

        return convertView;
    }

    private void sayilariDoldur(){
        Sayi sayi = new Sayi();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer[] sayiArray = {1, 3, 5, 7, 9, 11, 13, 15,
                17, 19, 21, 23, 25, 27, 29, 31,
                33, 35, 37, 39, 41, 43, 45, 47,
                49, 51, 53, 55, 57, 59, 61, 63};
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(11);
        arrayList.add(13);
        arrayList.add(15);
        sayi.setSayilar(arrayList);
        sayilar.add(sayi);
        sayilar.add(sayi);
        /*sayilar.add(new Sayi().setSayilar(new int[]{2, 3, 6, 7, 10, 11, 14, 15,
                18, 19, 22, 23, 26, 27, 30, 31,
                34, 35, 38, 39, 42, 43, 46, 47,
                50, 51, 54, 55, 58, 59, 62, 63}));
        sayilar.add(new Sayi().setSayilar(new int[]{4, 5, 6, 7, 12, 13, 14, 15,
                20, 21, 22, 23, 28, 29, 30, 31,
                36, 37, 38, 39, 44, 45, 46, 47,
                52, 53, 54, 55, 60, 61, 62, 63}));*/
        //sayilar.add(new Sayi().setSayilar(new int[]{}));
        //sayilar.add(new Sayi().setSayilar(new int[]{}));
        //sayilar.add(new Sayi().setSayilar(new int[]{}));
    }
}
