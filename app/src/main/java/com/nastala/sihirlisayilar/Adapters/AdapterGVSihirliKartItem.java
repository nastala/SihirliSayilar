package com.nastala.sihirlisayilar.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nastala.sihirlisayilar.R;

import java.util.ArrayList;

public class AdapterGVSihirliKartItem extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<Integer>  sayilar;

    public AdapterGVSihirliKartItem(Activity activity, ArrayList<Integer> sayilar){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sayilar = sayilar;
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
            convertView = layoutInflater.inflate(R.layout.adapter_gvsihirlikart_item, parent, false);

        String sayi = sayilar.get(position) + "";
        TextView tvSayi = convertView.findViewById(R.id.tvSayi);
        tvSayi.setText(sayi);

        Log.d("ADAPTERGVITEM", sayilar.size() + " sıradaki sayi: " + sayi + " position: " + position);
        return convertView;
    }
}
