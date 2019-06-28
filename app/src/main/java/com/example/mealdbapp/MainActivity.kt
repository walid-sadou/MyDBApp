package com.example.mealdbapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log;
import java.net.HttpURLConnection
import java.net.URL
import android.os.StrictMode
import android.util.JsonReader
import org.json.JSONObject
import org.json.JSONTokener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val connection = URL("https://www.themealdb.com/api/json/v1/1/categories.php").openConnection() as HttpURLConnection
        try {
            val data = connection.inputStream.bufferedReader().readText()
            Log.d("test", data)
            val datajson = JSONObject(data)
            Log.d("data", datajson.toString())
            val categories =  datajson.getJSONArray("categories")
            Log.d("Categories", categories.toString())



        } finally {
            connection.disconnect()
        }
    }
}
