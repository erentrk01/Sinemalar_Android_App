package com.android.sinemalar.responses;

import com.android.sinemalar.models.Movie;
import com.android.sinemalar.models.Ontheater;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OntheatersResponse {
    @SerializedName("ontheaters")
    private List<List<Ontheater>> ontheaters;

    public List<List<Ontheater>> getOntheatersHome() {
        return ontheaters;
    }
}
