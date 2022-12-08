package com.android.sinemalar.responses;

import com.android.sinemalar.models.PopularArtist;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularArtistsResponse {
    @SerializedName("popularArtists")
    private List<PopularArtist> popularArtists;

    public List<PopularArtist> getPopularArtists() {
        return popularArtists;
    }
}
