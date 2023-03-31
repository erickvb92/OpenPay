package com.upax.openpay.api

import com.upax.openpay.model.Response_moviedb
import com.upax.openpay.model.Response_review
import retrofit2.Response
import retrofit2.http.GET

private const val ENDPOINT = "movie"
private const val id_review = "641ecaedc613ce00e0f1a440"

interface API {

    @GET("$ENDPOINT/popular")
    suspend fun getRequestPopular(): Response<Response_moviedb>

    @GET("$ENDPOINT/now_playing")
    suspend fun getRequestNow(): Response<Response_moviedb>

    @GET("$ENDPOINT/top_rated")
    suspend fun getRequestTop(): Response<Response_moviedb>

    @GET("review/$id_review")
    suspend fun getRequestPerfil(): Response<Response_review>

}