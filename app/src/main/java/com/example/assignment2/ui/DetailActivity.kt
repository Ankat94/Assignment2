package com.example.assignment2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.assignment2.R
import com.example.assignment2.databinding.ActivityDetailBinding
import com.example.assignment2.network.Artist

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        val model: DetailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.detailModel = model

        val data = intent.extras?.get("Artist") as Artist
        model.artist = data
    }
}
