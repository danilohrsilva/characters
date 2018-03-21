package com.example.drodrigues.heroespoc.gateway.network.services;


import com.example.drodrigues.heroespoc.entity.marvel.MarvelResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {


    @GET("v1/public/characters")
    Call<MarvelResult> getMarvelCharacters(@Query("limit") int limit,
                                           @Query("offset") int offset);

}
