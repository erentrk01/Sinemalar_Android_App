package com.android.sinemalar.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.android.sinemalar.repositories.PopularArtistsRepository;

import com.android.sinemalar.responses.PopularArtistsResponse;

public class PopularArtistsViewModel extends ViewModel {
    private PopularArtistsRepository popularArtistsRepository;
    public PopularArtistsViewModel(){
        popularArtistsRepository = new PopularArtistsRepository();
    }
    public LiveData<PopularArtistsResponse> getPopularArtistsHome(){
        return popularArtistsRepository.getPopularArtistsHome();
    }
}
