package com.example.get_giphy_retrofit

import retrofit2.http.GET

interface ApiService {
    @GET("gifs/trending?api_key=vtlLHabCgeggROgtrD2qUIDjSaUp8c6k&limit=25&rating=g")
    fun getData():retrofit2.Call<DataResult>
}