package com.android.sinemalar.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sinemalar.MainActivity;
import com.android.sinemalar.MovieActivity;
import com.android.sinemalar.R;
import com.android.sinemalar.models.Movie;
import com.android.sinemalar.models.Ontheater;
import com.android.sinemalar.utilities.Actor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// got this part from lab guide and I have changed necessary things.
public class OntheatersRecyclerViewAdapter  extends RecyclerView.Adapter< OntheatersRecyclerViewAdapter.OntheatersRecyclerViewItemHolder>{
    private Context context;
    private GestureDetectorCompat gestureDetector;
    private OntheatersRecyclerViewAdapter.CustomGestureListener customGestureListener;


    private List<List<Ontheater>>recyclerOntheaterItemValues;

    public OntheatersRecyclerViewAdapter(Context context, List<List<Ontheater>> values){
        this.context = context;
        this.recyclerOntheaterItemValues = values;

    }

    @NonNull
    @Override
    public OntheatersRecyclerViewAdapter.OntheatersRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_ontheater_item, viewGroup, false);


        OntheatersRecyclerViewItemHolder mViewHolder = new  OntheatersRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OntheatersRecyclerViewAdapter.OntheatersRecyclerViewItemHolder holder, int position) {
        final List<Ontheater> movieItem = recyclerOntheaterItemValues.get(position);

        String movieItemName = movieItem.get(0).getName();
        String genreName= movieItem.get(0).getGenres();
        String productYear = movieItem.get(0).getProductYear();
        String imgUrl = movieItem.get(0).getImage();
        String org_name =movieItem.get(0).getOrg_name();
        ArrayList<String> actors= movieItem.get(0).getActorNames();
        int duration = movieItem.get(0).getDuration();

        holder.tvMainTitle.setText(movieItemName);

        // Image Download using Picasso
        Picasso.get()
                .load(movieItem.get(0).getImage())
                .into(holder.img);

        customGestureListener = new OntheatersRecyclerViewAdapter.CustomGestureListener();
        gestureDetector = new GestureDetectorCompat(context, customGestureListener);
        holder.tvMainTitle.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(context, MovieActivity.class);
                intent.putExtra("id",movieItem.get(0).getId()+"");
                intent.putExtra("movieName", movieItemName);
                intent.putExtra("genreName",genreName);
                intent.putExtra("productYear",productYear);
                intent.putExtra("actors",actors);
                intent.putExtra("imgUrl",imgUrl);
                intent.putExtra("duration",duration +"");
                intent.putExtra("org_name",org_name);
                context.startActivity(intent);

                return gestureDetector.onTouchEvent(motionEvent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return recyclerOntheaterItemValues.size();
    }

    public class OntheatersRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView tvMovieSubtitle,tvMainTitle;
        ImageView img;
        ConstraintLayout parentLayout;
        public OntheatersRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            tvMainTitle = itemView.findViewById(R.id.ontheaterMovieName);
            img = itemView.findViewById(R.id.ontheaterimageView);
            parentLayout = itemView.findViewById(R.id.itemOntheatermovieConstraintLayout);
        }
    }

    class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent event) {
            Toast.makeText(context, "onDown Over Image", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            Toast.makeText(context, "onSingleTapConfirmed Over Image", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            Toast.makeText(context, "onDoubleTapEvent Over Image",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            Toast.makeText(context, "onLongPress Over Image", Toast.LENGTH_SHORT).show();
        }
    }


}
