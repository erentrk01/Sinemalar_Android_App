package com.android.sinemalar.models;

import com.google.gson.annotations.SerializedName;



public class Ontheater {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    String name;
    @SerializedName("image")
    String image;
    @SerializedName("org_name")
    String org_name;
    @SerializedName("url")
    String url;
    @SerializedName("genres")
    String genres;
    @SerializedName("produce_year")
    String productYear;



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getOrg_name() {
        return org_name;
    }

    public String getUrl() {
        return url;
    }

    public String getGenres() {
        return genres;
    }

    public String getProductYear() {
        return productYear;
    }
}

