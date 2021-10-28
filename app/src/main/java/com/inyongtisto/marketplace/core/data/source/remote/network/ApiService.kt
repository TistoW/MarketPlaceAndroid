package com.inyongtisto.marketplace.core.data.source.remote.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        //@Body user: User
    ): Response<RequestBody>

}