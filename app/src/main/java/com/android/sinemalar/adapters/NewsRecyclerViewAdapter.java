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
import com.android.sinemalar.models.News;
import com.android.sinemalar.models.Ontheater;
import com.squareup.picasso.Picasso;

import java.util.List;

// got this part from lab guide and I have changed necessary things.
public class NewsRecyclerViewAdapter  extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsRecyclerViewItemHolder>{
    private Context context;
    private List<News> recyclerItemValues;


    public NewsRecyclerViewAdapter(Context context, List<News> values){
        this.context = context;
        this.recyclerItemValues = values;

    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.NewsRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_news_item, viewGroup, false);


        NewsRecyclerViewItemHolder mViewHolder = new NewsRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.NewsRecyclerViewItemHolder holder, int position) {
        final News newsItem = recyclerItemValues.get(position);
        String newsItemName = newsItem.getTitle();
        String ago=newsItem.getAgo();
        holder.tvNewsTitle.setText(newsItemName);
        holder.tvNewsAgo.setText(ago);
        // Image Download using Picasso
        Picasso.get()
                .load(newsItem.getImage())
                .into(holder.img);



    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    public class NewsRecyclerViewItemHolder extends RecyclerView.ViewHolder {
        TextView tvNewsAgo,tvNewsTitle;
        ImageView img;
        ConstraintLayout parentLayout;
        public NewsRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            tvNewsTitle = itemView.findViewById(R.id.newsTitleTv);
            tvNewsAgo = itemView.findViewById(R.id.agoTextView);
            img = itemView.findViewById(R.id.imageViewNews);
            parentLayout = itemView.findViewById(R.id.itemSeansConstraintLayout);
        }
    }
}
