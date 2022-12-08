package com.android.sinemalar.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.android.sinemalar.repositories.MoviesRepository;
import com.android.sinemalar.responses.MoviesResponse;

public class MoviesViewModel extends ViewModel {
    private MoviesRepository moviesRepository;
    public MoviesViewModel(){
        moviesRepository = new MoviesRepository();
    }
    public LiveData<MoviesResponse> getMoviesHome(){
        return moviesRepository.getMoviesHome();
    }
}
