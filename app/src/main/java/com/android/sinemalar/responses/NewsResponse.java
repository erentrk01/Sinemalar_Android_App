package com.android.sinemalar.responses;

import com.android.sinemalar.models.Movie;
import com.android.sinemalar.models.News;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("news")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }
}
