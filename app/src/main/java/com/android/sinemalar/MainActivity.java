package com.android.sinemalar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.android.sinemalar.adapters.SeansMoviesRecyclerViewAdapter;
import com.android.sinemalar.adapters.NewsRecyclerViewAdapter;
import com.android.sinemalar.adapters.OntheatersRecyclerViewAdapter;
import com.android.sinemalar.adapters.PopularArtistsRecyclerViewAdapter;
import com.android.sinemalar.databinding.ActivityMainBinding;
import com.android.sinemalar.models.Movie;
import com.android.sinemalar.models.News;
import com.android.sinemalar.models.Ontheater;
import com.android.sinemalar.models.PopularArtist;
import com.android.sinemalar.viewmodels.MoviesViewModel;
import com.android.sinemalar.viewmodels.NewsViewModel;
import com.android.sinemalar.viewmodels.OntheatersViewModel;
import com.android.sinemalar.viewmodels.PopularArtistsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    RecyclerView recyclerMovieSeans;
    // Adapter for Recycle Seans Movies
    SeansMoviesRecyclerViewAdapter adapter;
    // Adapter fro Recycle Ontheater Movies
    OntheatersRecyclerViewAdapter ontheaterAdapter;
    //Adapter for Recycle PopularArtists
    PopularArtistsRecyclerViewAdapter popularArtistsAdapter;
    //Adapter for News
    NewsRecyclerViewAdapter newsRecyclerViewAdapter;

    //LayoutManager for recyclerMovieSeans
    LinearLayoutManager layoutManager;
    //LayoutManager for recyclerOntheater Movies
    LinearLayoutManager layoutManagerOntheater;
    //Layout Manager for recycler PopularArtists
    LinearLayoutManager layoutManagerPopularArtist;
    //LayoutManager for recycler News
    LinearLayoutManager layoutManagerNews;


    private MoviesViewModel viewModel;
    private OntheatersViewModel ontheatersViewModel;
    private PopularArtistsViewModel popularArtistsViewModel;
    private NewsViewModel newsViewModel;

    List<Movie> moviesData= new ArrayList<>();
    List<List<Ontheater>> ontheatersData= new ArrayList<>();
    List<PopularArtist> popularArtistsData = new ArrayList<>();
    List<News> newsData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set status bar color  got this part from geeksfor.geeks.org @encrypter09
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);
        doInitilaziation();

    }

    // GET RESPONSE DATA

    private void getMoviesHome(){
        viewModel.getMoviesHome().observe(this,moviesResponse -> {
                if(moviesResponse != null) {
                    if(moviesResponse.getMoviesHome()!=null){
                        moviesData.addAll(moviesResponse.getMoviesHome());
                        adapter.notifyDataSetChanged();
                    }

                }
        });
    }


    private void getOntheatersHome(){
        ontheatersViewModel.getOntheatersHome().observe(this,ontheatersResponse -> {
            if(ontheatersResponse != null)
            {
                if(ontheatersResponse.getOntheatersHome()!=null){
                    ontheatersData.addAll(ontheatersResponse.getOntheatersHome());
                    //Log.d("ontheater:","hey");

                    ontheaterAdapter.notifyDataSetChanged();

                }
            }
        });
    }
    private void getPopularArtistsHome(){
        popularArtistsViewModel.getPopularArtistsHome().observe(this,popularArtistsResponse -> {
            if(popularArtistsResponse != null)
            {
                if(popularArtistsResponse.getPopularArtists()!=null){
                    popularArtistsData.addAll(popularArtistsResponse.getPopularArtists());
                    popularArtistsAdapter.notifyDataSetChanged();

                }
            }
        });
    }

    private void getNewsHome(){
        newsViewModel.getNewsHome().observe(this,newsResponse -> {
            if(newsResponse != null){
                newsData.addAll(newsResponse.getNewsList());
                newsRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void doInitilaziation(){

        binding.recyclerSeans.setHasFixedSize(true);
        binding.recyclerOntheaters.setHasFixedSize(true);
        binding.popularArtistsRecyclerView.setHasFixedSize(true);

        // VIEW MODELS
        // Seans movie view model
        viewModel = new ViewModelProvider(MainActivity.this).get(MoviesViewModel.class);
        getMoviesHome();

        // Ontheater movie view model
        ontheatersViewModel = new ViewModelProvider(MainActivity.this).get(OntheatersViewModel.class);
        getOntheatersHome();

        // PopularArtist view model
        popularArtistsViewModel = new ViewModelProvider(MainActivity.this).get(PopularArtistsViewModel.class);
        getPopularArtistsHome();

        //News Recycler view model
        newsViewModel =new ViewModelProvider(MainActivity.this).get(NewsViewModel.class);
        getNewsHome();

        //Fill the Recycler Seans Movies
        //Layout Managers
        layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        layoutManagerOntheater =new LinearLayoutManager(MainActivity.this);
        layoutManagerOntheater.setOrientation(LinearLayoutManager.HORIZONTAL);

        layoutManagerPopularArtist = new LinearLayoutManager(MainActivity.this);
        layoutManagerPopularArtist.setOrientation(LinearLayoutManager.HORIZONTAL);

        layoutManagerNews = new LinearLayoutManager(MainActivity.this);
        layoutManagerNews.setOrientation(LinearLayoutManager.VERTICAL);


        // Recycler Seans Movies
        binding.recyclerSeans.setLayoutManager(layoutManager);
        // Recycler Ontheater Movies
        binding.recyclerOntheaters.setLayoutManager(layoutManagerOntheater);
        // Recycler PopularArtists
        binding.popularArtistsRecyclerView.setLayoutManager(layoutManagerPopularArtist);
        //Recycler News
        binding.recyclerNews.setLayoutManager(layoutManagerNews);


        //FILL ADAPTERS
        adapter = new SeansMoviesRecyclerViewAdapter(MainActivity.this, moviesData);
        binding.recyclerSeans.setAdapter(adapter);

        ontheaterAdapter = new OntheatersRecyclerViewAdapter(MainActivity.this,ontheatersData);
        binding.recyclerOntheaters.setAdapter(ontheaterAdapter);

        popularArtistsAdapter =  new PopularArtistsRecyclerViewAdapter(MainActivity.this,popularArtistsData);
        binding.popularArtistsRecyclerView.setAdapter(popularArtistsAdapter);

        newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(MainActivity.this,newsData);
        binding.recyclerNews.setAdapter(newsRecyclerViewAdapter);



    }
}