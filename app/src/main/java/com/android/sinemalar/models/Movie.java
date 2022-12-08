package com.android.sinemalar.models;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    String name;
    @SerializedName("image")
    String image;
    @SerializedName("ontheaters")
    String ontheaters;
    @SerializedName("org_name")
    String org_name;
    @SerializedName("pub_date_formatted")
    String pub_date_formatted;


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getOrg_name() {
        return org_name;
    }
}
