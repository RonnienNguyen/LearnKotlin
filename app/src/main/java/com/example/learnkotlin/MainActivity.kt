package com.example.learnkotlin

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import MyAdapter


const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Dong recylview la goi tu id cua layout
        recyclerview.setHasFixedSize(true)

        //dong linear la khai bao o tren private int
        linearLayoutManager = LinearLayoutManager(this)

        //layoutmanger la cc gi day

        //Co the gop chung lai nhu the nay
        //recycleview.layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
        getMyData();
    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>){

                val responseBody = response.body()!!

//                val myStringBuilder = StringBuilder()
//                for (myData in responseBody){
//                    myStringBuilder.append(myData.id)
//                    myStringBuilder.append("\n")
//                }
//
//
//                meow.text = myStringBuilder.toString()

//                recycler_view
                  //Get ID from Element hehe
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                //Log.e(tag: "Error", t.message.toString())
                d("MainActivity", "onFailure: " + t.message)
                TODO("Not yet implemented")
            }
        })
    }
}