package com.freedii.app.spike.utilslibrary

import com.freedii.app.spike.utilslibrary.model.Document
import com.freedii.app.spike.utilslibrary.network.NetworkAPIs
import com.freedii.app.spike.utilslibrary.network.RetrofitHelper
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


interface UtilsUpdateListener {
    fun onUpdated(updateJson: String)
    fun onUpdated(list: List<Document>)
}

//coder
//class Utils {
object Utils {
    private val indexApi = RetrofitHelper.getInstance().create(NetworkAPIs.IndexApi::class.java)

    suspend fun doGetInfo(): List<Document>? {
        val index = indexApi.getIndex().body()
        return index
    }

    fun getInfo(listener: UtilsUpdateListener) {
        val resultList = mutableListOf<Document>()

        CoroutineScope(Dispatchers.IO).launch {
            val result = doGetInfo()
            result?.map {
                val title = it.title
                val url = it.url

                println("=====================================")
                println("=============>title: $title")
                println("=============>url: $url")

                resultList.add(it)
            }

            //callback 1
            result?.let {
                listener.onUpdated(it)
            }

            //callback 2
            val gson = GsonBuilder().setPrettyPrinting().create()
            val json = gson.toJson(result) // converts to json
            listener.onUpdated(json)
        }
    }

}