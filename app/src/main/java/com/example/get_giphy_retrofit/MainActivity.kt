package com.example.get_giphy_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val gif= mutableListOf<DataObject>()
    lateinit var adapter:DataAdapter
    lateinit var search:Button
    lateinit var value:EditText
    val query="q=query"
    //val baseurl="https://api.giphy.com/v1/"
    val baseurl="https://api.giphy.com/v1/&&limit=25&offset=0&rating=g&lang=en"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recycler)
        recyclerView.layoutManager=GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)
        adapter=DataAdapter(this,gif)
        recyclerView.adapter=adapter
        getMyData()
        search=findViewById(R.id.search)
        value=findViewById(R.id.value)
        search.setOnClickListener(View.OnClickListener {



        })

    }

    private fun getMyData() {
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseurl)
            .build()
        val retrofata=retrofit.create(ApiService::class.java).getData()
        retrofata.enqueue(object : Callback<DataResult?> {
            override fun onResponse(call: Call<DataResult?>, response: Response<DataResult?>) {
                val body=response.body()
                if (body==null){
                    Log.d("MainActivty","notresponse")
                }
             gif.addAll(body!!.res)

                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<DataResult?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}