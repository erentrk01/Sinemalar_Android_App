package com.android.sinemalar.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.sinemalar.network.ApiClient;
import com.android.sinemalar.network.ApiService;

import com.android.sinemalar.responses.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private ApiService apiService;
    public  NewsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }
    public LiveData<NewsResponse> getNewsHome(){
        MutableLiveData<NewsResponse> data = new MutableLiveData<>();
        apiService.getNewsHome().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<NewsResponse> call,@NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return  data;
    }
}
