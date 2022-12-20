package com.android.sinemalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sinemalar.databinding.ActivityMovieBinding;
import com.android.sinemalar.database.DatabaseHelper;
import com.android.sinemalar.database.FavoriteMoviesTable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    ActivityMovieBinding binding;
    DatabaseHelper dbHelper;
    ImageView imgView;
    TextView summaryTv,movieName;
    private GestureDetectorCompat gestureDetector;
    private CustomGestureListener customGestureListener;
    Dialog customDialog;
    TextView titleDialog;
    ImageView imgDialog;
    String receivedName;
    String imgUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        dbHelper = new DatabaseHelper(this);





        customGestureListener = new CustomGestureListener();
        gestureDetector = new GestureDetectorCompat(this, customGestureListener);
        Intent receivedIntent = getIntent();
        receivedName = receivedIntent.getStringExtra("movieName");
        String genreName= receivedIntent.getStringExtra("genreName");
        ArrayList<String> actors= receivedIntent.getStringArrayListExtra("actors");
        String productYear =  receivedIntent.getStringExtra("productYear");
         imgUrl =  receivedIntent.getStringExtra("imgUrl");
        int duration = Integer.parseInt(receivedIntent.getStringExtra("duration"));
        String org_name = receivedIntent.getStringExtra("org_name");
        int id = Integer.parseInt(receivedIntent.getStringExtra("id"));


        // Image Download using Picasso
        Picasso.get()
                .load(imgUrl)
                .into(binding.imageView2);
        binding.movieNameHeaderTv.setText(receivedName);
        binding.genreTv.setText(genreName);
        binding.durationTv.setText(duration +" minutes");
        binding.productYearTv.setText(productYear);

        createDailog();
        // Fill the Actors List View
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, actors){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };

        //(C) adımı
        binding.actorlist.setAdapter(adapter);

        //add favs db
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SysFavs.addOntheatersFav();
                customDialog.show();
                boolean resinser = FavoriteMoviesTable.insertMovie(dbHelper,id,receivedName,imgUrl,org_name,genreName,productYear,duration);
                if(resinser){

                    Toast.makeText(MovieActivity.this,"fav Inserted "+ resinser,Toast.LENGTH_LONG).show();
                }
                else{

                    Toast.makeText(MovieActivity.this,"fav not Inserted "+ resinser,Toast.LENGTH_LONG).show();
                }
            }
        });



        binding.imageView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //return MainActivity.this.mDetector.onTouchEvent(motionEvent);
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }
    public void createDailog() {
        customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.custdialog);
        titleDialog = customDialog.findViewById(R.id.textView3);

        imgDialog = customDialog.findViewById(R.id.imageView3);
        titleDialog.setText( receivedName +" will be added to Favs");
        Picasso.get()
                .load(imgUrl)
                .into(imgDialog);

        customDialog.create();
    }


    class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Toast.makeText(getBaseContext(), "onDown Over Image", Toast.LENGTH_SHORT).show();

            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            Toast.makeText(getBaseContext(), "onSingleTapConfirmed Over Image", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            Toast.makeText(getBaseContext(), "onDoubleTapEvent Over Image",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            Toast.makeText(getBaseContext(), "onLongPress Over Image", Toast.LENGTH_SHORT).show();
        }
    }

}