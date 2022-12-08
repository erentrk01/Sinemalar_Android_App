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

import com.android.sinemalar.models.PopularArtist;
import com.squareup.picasso.Picasso;

import java.util.List;

// got this part from lab guide and I have changed necessary things.
public class PopularArtistsRecyclerViewAdapter  extends RecyclerView.Adapter<PopularArtistsRecyclerViewAdapter.PopularArtistsRecyclerViewItemHolder>{
    private Context context;
    private List<PopularArtist>recyclerPopularArtistsItemValues;

    public PopularArtistsRecyclerViewAdapter(Context context, List<PopularArtist> values){
        this.context = context;
        this.recyclerPopularArtistsItemValues = values;

    }

    @NonNull
    @Override
    public PopularArtistsRecyclerViewAdapter.PopularArtistsRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_popularartist_item, viewGroup, false);


        PopularArtistsRecyclerViewItemHolder mViewHolder = new PopularArtistsRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularArtistsRecyclerViewAdapter.PopularArtistsRecyclerViewItemHolder holder, int position) {
        final PopularArtist popularArtistItem = recyclerPopularArtistsItemValues.get(position);
        String popularArtistItemName = popularArtistItem.getName_surname();
        holder.popularActorName.setText(popularArtistItemName);
        // Image Download using Picasso
        Picasso.get()
                .load(popularArtistItem.getPicture())
                .into(holder.img);



    }

    @Override
    public int getItemCount() {
        return recyclerPopularArtistsItemValues.size();
    }

    public class PopularArtistsRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView popularActorName;
        ImageView img;
        ConstraintLayout parentLayout;
        public PopularArtistsRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            popularActorName = itemView.findViewById(R.id.tvPopularActorname);
            img = itemView.findViewById(R.id.popularActorImageView);
            parentLayout = itemView.findViewById(R.id.itemSeansConstraintLayout);
        }
    }
}
