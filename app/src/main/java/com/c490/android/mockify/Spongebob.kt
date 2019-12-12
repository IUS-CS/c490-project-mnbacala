package com.c490.android.mockify
import com.google.gson.annotations.SerializedName

data class Spongebob (
    @SerializedName("id")
    var id: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("width")
    var width: Int,
    @SerializedName("height")
    var height: Int,
    @SerializedName("box_count")
    var box_count: Int
)
//  "id":"102156234",
//  "name":"Mocking Spongebob"
//  "url":"https://i.imgflip.com/1otk96.jpg"
//  "width":502
//  "height":353
//  "box_count":2