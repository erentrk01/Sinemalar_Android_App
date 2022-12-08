package com.android.sinemalar.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.sinemalar.network.ApiClient;
import com.android.sinemalar.network.ApiService;
import com.android.sinemalar.responses.NewsResponse;
import com.android.sinemalar.responses.OntheatersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OntheatersRepository {
    private ApiService apiService;
    public  OntheatersRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }
    public LiveData<OntheatersResponse> getOntheatersHome(){
        MutableLiveData<OntheatersResponse> data = new MutableLiveData<>();
        apiService.getOntheatersHome().enqueue(new Callback<OntheatersResponse>() {
            @Override
            public void onResponse(@NonNull Call<OntheatersResponse> call, @NonNull Response<OntheatersResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<OntheatersResponse> call,@NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return  data;
    }
}
