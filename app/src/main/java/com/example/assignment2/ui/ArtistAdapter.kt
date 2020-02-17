package com.example.assignment2.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.databinding.ArtistLayoutBinding
import com.example.assignment2.network.Artist
import java.io.Serializable

class ArtistAdapter(
    private val artists: List<Artist>,
    private val context: Context
): RecyclerView.Adapter<ArtistAdapter.ArtistHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistHolder = ArtistHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.artist_layout,
        parent,false))

    override fun onBindViewHolder(holder: ArtistHolder, position: Int) {
        holder.artistLayoutBinding.artist = artists[position]
        holder.artistLayoutBinding.button.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java).also {
                it.putExtra("Artist", artists[position] as Serializable)
                context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int = artists.size



    inner class ArtistHolder(
        val artistLayoutBinding: ArtistLayoutBinding
    ) : RecyclerView.ViewHolder(artistLayoutBinding.root)
}