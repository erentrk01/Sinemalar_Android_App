package com.android.sinemalar.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.android.sinemalar.repositories.NewsRepository;
import com.android.sinemalar.repositories.OntheatersRepository;
import com.android.sinemalar.responses.NewsResponse;
import com.android.sinemalar.responses.OntheatersResponse;

public class OntheatersViewModel extends ViewModel {
    private OntheatersRepository ontheatersRepository;
    public OntheatersViewModel(){
        ontheatersRepository = new OntheatersRepository();
    }
    public LiveData<OntheatersResponse> getOntheatersHome(){
        return ontheatersRepository.getOntheatersHome();
    }
}
