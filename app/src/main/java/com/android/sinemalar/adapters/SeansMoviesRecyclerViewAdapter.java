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
public class SeansMoviesRecyclerViewAdapter extends RecyclerView.Adapter<SeansMoviesRecyclerViewAdapter.CustomRecyclerViewItemHolder>{
    private Context context;
    private List<Movie> recyclerItemValues;
    private List<Ontheater>recyclerOntheaterItemValues;

    public SeansMoviesRecyclerViewAdapter(Context context, List<Movie> values){
        this.context = context;
        this.recyclerItemValues = values;
    }

    @NonNull
    @Override
    public SeansMoviesRecyclerViewAdapter.CustomRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_seans_item, viewGroup, false);

        CustomRecyclerViewItemHolder mViewHolder = new CustomRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeansMoviesRecyclerViewAdapter.CustomRecyclerViewItemHolder holder, int position) {
        final Movie movieItem = recyclerItemValues.get(position);
        String movieItemName = movieItem.getName();
        String orgName = movieItem.getOrg_name();
        holder.tvMainTitle.setText(movieItemName);
        holder.tvMovieSubtitle.setText(orgName);
        // Image Download using Picasso
        Picasso.get()
                .load(movieItem.getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    public class CustomRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView tvMovieSubtitle,tvMainTitle;
        ImageView img;
        ConstraintLayout parentLayout;
        public CustomRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            tvMainTitle = itemView.findViewById(R.id.TvmovieTitle);
            tvMovieSubtitle = itemView.findViewById(R.id.tvmovieSubtitle);
            img = itemView.findViewById(R.id.movieImageViewItem);
            parentLayout = itemView.findViewById(R.id.itemSeansConstraintLayout);
        }
    }
}
