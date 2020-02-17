package com.example.assignment2.network

import java.io.Serializable

data class Artist(
    var albumId: Int,
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String
): Serializable