package com.example.assignment2.repo


import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.assignment2.network.Artist
import com.example.assignment2.network.DataResponse
import com.example.assignment2.network.MyApi
import com.example.assignment2.network.OnResponseListener
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class ArtistRepository {

     fun getArtistData(context: Context)  {

         val onResponseListener = context as OnResponseListener

         if (!(checkNetWorkConnection(context))) {
             onResponseListener.onFailure("Check Internet Connection!!")
             return
         }



        MyApi().getData().enqueue(object : Callback<List<Artist>> {
            override fun onFailure(call: Call<List<Artist>>, t: Throwable) {
                t.message?.let { onResponseListener.onFailure(it) }
            }

            override fun onResponse(call: Call<List<Artist>>, response: Response<List<Artist>>) {
                val data = response.body()
                data?.let { onResponseListener.onSuccess(it) }
            }

        })

    }

    @SuppressLint("ServiceCast")
    fun checkNetWorkConnection(context: Context): Boolean{
        val connectivityManager= context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}