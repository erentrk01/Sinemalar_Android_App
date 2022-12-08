package com.android.sinemalar.network;

import com.android.sinemalar.responses.MoviesResponse;
import com.android.sinemalar.responses.NewsResponse;
import com.android.sinemalar.responses.OntheatersResponse;
import com.android.sinemalar.responses.PopularArtistsResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {
    @GET("test/v1/home")
    Call<MoviesResponse> getMoviesHome();
    @GET("test/v1/home")
    Call<OntheatersResponse> getOntheatersHome();
    @GET("test/v1/home")
    Call<NewsResponse> getNewsHome();
    @GET("test/v1/home")
    Call<PopularArtistsResponse> getPopularArtistsHome();
}
