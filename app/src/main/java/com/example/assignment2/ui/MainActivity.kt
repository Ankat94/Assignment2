package com.example.assignment2.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.util.Coroutines
import com.example.assignment1.util.toast
import com.example.assignment2.R
import com.example.assignment2.databinding.ActivityMainBinding
import com.example.assignment2.network.Artist
import com.example.assignment2.network.OnResponseListener
import com.example.assignment2.repo.ArtistRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnResponseListener {

    lateinit var binding: ActivityMainBinding
    lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = DataBindingUtil.setContentView(this,
            R.layout.activity_main)
        model = ViewModelProvider(this).get(MainViewModel::class.java)

        Coroutines.main {
            val data = ArtistRepository().getArtistData(this)
        }
    }

    override fun onFailure(message: String) {
       runOnUiThread{
           toast(message)
           progressBar.visibility = View.GONE
       }
    }

    override fun onSuccess(artistData: List<Artist>) {
        main_recycle.also {
            it.layoutManager = LinearLayoutManager(this)
            it.setHasFixedSize(true)
            it.adapter = ArtistAdapter(artistData,this)
            progressBar.visibility = View.GONE
        }
    }
}
