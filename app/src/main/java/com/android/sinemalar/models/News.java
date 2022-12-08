package com.android.sinemalar.models;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    String title;
    @SerializedName("ago")
    String ago;
    @SerializedName("image")
    String image;
    @SerializedName("url")
    String url;
    @SerializedName("add_date")
    String add_date;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAgo() {
        return ago;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public String getAdd_date() {
        return add_date;
    }
}
