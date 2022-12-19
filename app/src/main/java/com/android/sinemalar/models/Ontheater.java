package com.android.sinemalar.models;

import com.android.sinemalar.utilities.Actor;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ontheater {
    private ArrayList<String>actorNames;
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
    @SerializedName("actors")
    ArrayList<Actor> actors;
    @SerializedName("duration")
    int duration;

    public Ontheater(int id, String name, String image, String org_name, String genres, String productYear, int duration) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.org_name = org_name;
        this.genres = genres;
        this.productYear = productYear;
        this.duration = duration;
    }

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

    public ArrayList<Actor> getActors() {
        return actors;
    }


    public ArrayList<String> getActorNames() {
        actorNames= new ArrayList<>();
        int i=0;
        try{
            while (i<actors.size())
            {
                actorNames.add(actors.get(i).getName_surname()) ;
                i++;
            }
        }catch (NullPointerException e){
            System.out.print("Null pointer");
        }

        return  actorNames;
    }

    public String getProductYear() {
        return productYear;
    }

    public int getDuration() {
        return duration;
    }
}

