package com.example.get_giphy_retrofit

import com.google.gson.annotations.SerializedName

data class DataResult(@SerializedName("data") val res:List<DataObject>)
data class DataObject(@SerializedName("images") val images:DataImages)
data class DataImages(@SerializedName("original") val ogImage:OgImage)
data class OgImage(val url:String)