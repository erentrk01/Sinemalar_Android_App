package com.android.sinemalar.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.android.sinemalar.repositories.MoviesRepository;
import com.android.sinemalar.repositories.NewsRepository;
import com.android.sinemalar.responses.MoviesResponse;
import com.android.sinemalar.responses.NewsResponse;

public class NewsViewModel extends ViewModel {
    private NewsRepository newsRepository;
    public NewsViewModel(){
        newsRepository = new NewsRepository();
    }
    public LiveData<NewsResponse> getNewsHome(){
        return newsRepository.getNewsHome();
    }
}
