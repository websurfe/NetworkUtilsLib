package com.freedii.app.spike.utilslibrary.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//REF: https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/
object RetrofitHelper {
    //https://www.healthcare.gov/api/index.json
    //val baseUrl = "https://quotable.io/"
    val baseUrl = "https://www.healthcare.gov"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }

}