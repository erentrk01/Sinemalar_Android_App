package com.android.sinemalar.responses;

import com.android.sinemalar.models.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("featured")
    private List<Movie> movies;

    public List<Movie> getMoviesHome() {
        return movies;
    }

}
