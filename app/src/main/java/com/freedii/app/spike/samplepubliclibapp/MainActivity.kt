package com.freedii.app.spike.samplepubliclibapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.freedii.app.spike.utilslibrary.Utils
import com.freedii.app.spike.utilslibrary.UtilsUpdateListener
import com.freedii.app.spike.utilslibrary.model.Document

//coder
//class MainActivity : AppCompatActivity() {
class MainActivity : AppCompatActivity(), UtilsUpdateListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.getInfo(this)
    }

    override fun onUpdated(updateJson: String) {
        println("====================>updateJson: $updateJson")
    }

    override fun onUpdated(list: List<Document>) {
        println("====================>list: $list")
    }
}