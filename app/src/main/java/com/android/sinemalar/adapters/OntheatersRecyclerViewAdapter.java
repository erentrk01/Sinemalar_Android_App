package com.android.sinemalar.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sinemalar.R;
import com.android.sinemalar.models.Movie;
import com.android.sinemalar.models.Ontheater;
import com.squareup.picasso.Picasso;

import java.util.List;

// got this part from lab guide and I have changed necessary things.
public class OntheatersRecyclerViewAdapter  extends RecyclerView.Adapter< OntheatersRecyclerViewAdapter.OntheatersRecyclerViewItemHolder>{
    private Context context;

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

        holder.tvMainTitle.setText(movieItemName);

        // Image Download using Picasso
        Picasso.get()
                .load(movieItem.get(0).getImage())
                .into(holder.img);



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
}
