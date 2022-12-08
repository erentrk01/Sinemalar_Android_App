package com.android.sinemalar.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.sinemalar.network.ApiClient;
import com.android.sinemalar.network.ApiService;
import com.android.sinemalar.responses.MoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRepository {
    private ApiService apiService;
    public  MoviesRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<MoviesResponse> getMoviesHome(){
        MutableLiveData<MoviesResponse> data = new MutableLiveData<>();
        apiService.getMoviesHome().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call,@NonNull Response<MoviesResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call,@NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return  data;
    }
}
