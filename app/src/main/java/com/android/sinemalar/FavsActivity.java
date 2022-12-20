package com.android.sinemalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.sinemalar.adapters.CustomSpinnerAdapter;
import com.android.sinemalar.database.DatabaseHelper;
import com.android.sinemalar.database.FavoriteMoviesTable;
import com.android.sinemalar.databinding.ActivityFavsBinding;
import com.android.sinemalar.models.Ontheater;

import java.util.ArrayList;


public class FavsActivity extends AppCompatActivity {
    ActivityFavsBinding binding;
    ArrayList<Ontheater>favsList;
    DatabaseHelper dbHelper;
    Ontheater selectedMovie;
    private int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavsBinding.inflate(getLayoutInflater());


        View view = binding.getRoot();

        setContentView(view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent receivedIntent = getIntent();
        String passed  = receivedIntent.getStringExtra("pass");

        //Create DatabaseHelper object after try catch statement
        dbHelper = new DatabaseHelper(this);
        prepareFavsData();

        //Fill the custom spinner
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this,favsList);
        binding.spinner.setAdapter(adapter);
        if(favsList.size() >0){
            Toast.makeText(this, "FAVS DISPLAYED", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(this, "THERE IS NO FAV", Toast.LENGTH_SHORT).show();
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Ontheater stemp = favsList.get(position);
                 selectedId =stemp.getId();



                //   ImageView imItem = view.findViewById(R.id.imgItemSocial);
                ConstraintLayout clayout = view.findViewById(R.id.itemspinnerConstraintLayout);



                clayout.setBackgroundColor(Color.rgb(221,230,134));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean  res;

                res = FavoriteMoviesTable.deleteMovie(dbHelper, selectedId);
                Toast.makeText(FavsActivity.this," DELETED SUCCESFULLY", Toast.LENGTH_SHORT).show();
                prepareFavsData();
                adapter.notifyDataSetChanged();


            }
        });


    }
    private void prepareFavsData() {
        favsList = FavoriteMoviesTable.getAllMovie(dbHelper);
    }
}