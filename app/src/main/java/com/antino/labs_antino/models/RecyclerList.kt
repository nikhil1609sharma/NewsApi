package com.antino.labs_antino.models

data class RecyclerList(val articles: ArrayList<RecyclerData>)
data class RecyclerData(val author:String,val description:String, val url:String, val title:String, val urlToImage: String, val source: Source)
data class Source(val name:String,)