package com.android.sinemalar.models;

import com.google.gson.annotations.SerializedName;

public class PopularArtist {
    @SerializedName("id")
    private int id;
    @SerializedName("name_surname")
    String name_surname;
    @SerializedName("picture")
    String picture;
    @SerializedName("url")
    String url;

    public int getId() {
        return id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public String getPicture() {
        return picture;
    }

    public String getUrl() {
        return url;
    }
}
