package com.android.sinemalar.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.sinemalar.network.ApiClient;
import com.android.sinemalar.network.ApiService;

import com.android.sinemalar.responses.PopularArtistsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


    public class PopularArtistsRepository {
        private ApiService apiService;
        public  PopularArtistsRepository(){
            apiService = ApiClient.getRetrofit().create(ApiService.class);
        }
        public LiveData<PopularArtistsResponse> getPopularArtistsHome(){
            MutableLiveData<PopularArtistsResponse> data = new MutableLiveData<>();
            apiService.getPopularArtistsHome().enqueue(new Callback<PopularArtistsResponse>() {
                @Override
                public void onResponse(@NonNull Call<PopularArtistsResponse> call, @NonNull Response<PopularArtistsResponse> response) {
                    data.setValue(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<PopularArtistsResponse> call,@NonNull Throwable t) {
                    data.setValue(null);
                }
            });
            return  data;
        }
    }

