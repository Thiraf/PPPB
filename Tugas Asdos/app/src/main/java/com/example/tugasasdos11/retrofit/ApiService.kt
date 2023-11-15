package com.example.tugasasdos11.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("search")
    fun getchess(): Call<ArrayList<PostResponse>>

}