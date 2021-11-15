package com.example.retrofitlibrary

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")    //End Url
    fun fetchQuestions(@Query("tagged") tags: String): retrofit2.Call<QuestionList>
}
