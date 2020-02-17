package com.example.assignment2.network

import androidx.lifecycle.LiveData

interface OnResponseListener {

    fun onFailure(message: String)
    fun onSuccess(artistData: List<Artist>)
}