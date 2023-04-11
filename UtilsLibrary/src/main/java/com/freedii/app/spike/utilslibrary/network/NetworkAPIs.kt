package com.freedii.app.spike.utilslibrary.network

import com.freedii.app.spike.utilslibrary.model.Document
import retrofit2.Response
import retrofit2.http.GET


class NetworkAPIs {
    //https://www.healthcare.gov/api/index.json
    interface IndexApi {
        @GET("/api/index.json")
        suspend fun getIndex(): Response<List<Document>>
    }
}