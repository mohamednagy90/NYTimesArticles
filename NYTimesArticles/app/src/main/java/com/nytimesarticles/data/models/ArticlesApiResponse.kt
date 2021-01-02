package com.nytimesarticles.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticlesApiResponse(

	@SerializedName("status") val status: String,
	@SerializedName("copyright") val copyright: String,
	@SerializedName("num_results") val num_results: Int,
	@SerializedName("results") val results: ArrayList<Article>

)