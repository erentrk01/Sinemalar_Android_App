package com.android.sinemalar.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;


import com.android.sinemalar.R;
import com.android.sinemalar.models.Ontheater;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter<Ontheater> {
    Context context;
    ArrayList<Ontheater> spinnerItemValues;

    public CustomSpinnerAdapter(@NonNull Context context,  ArrayList<Ontheater> spinnerItemValues) {
        super(context, R.layout.favspinnerlayout,spinnerItemValues);
        this.context = context;
        this.spinnerItemValues = spinnerItemValues;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position,convertView,parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflator.inflate(R.layout.favspinnerlayout, parent, false);

        ConstraintLayout constraintLayout = view.findViewById(R.id.itemspinnerConstraintLayout);
        ImageView imgItemProduct = view.findViewById(R.id.spinnerImg);

        //values
        TextView movieName = view.findViewById(R.id.spinItemTitleTv);
        TextView genreName = view.findViewById(R.id.itemgenreTv);
        //titles
        TextView duration = view.findViewById(R.id.durationItemTv);


        Ontheater selectedProduct = spinnerItemValues.get(position);
        movieName.setText(selectedProduct.getName());
        genreName.setText(selectedProduct.getGenres());
        // Image Download using Picasso
        Picasso.get()
                .load(selectedProduct.getImage())
                .into(imgItemProduct);

        duration.setText(""+ selectedProduct.getDuration());




        if(position % 2 == 0)
            constraintLayout.setBackgroundColor(Color.rgb(167,129,183));
        else
            constraintLayout.setBackgroundColor(Color.rgb(254,81,255));


        return view;
    }
}