package com.inyongtisto.marketplace.core.data.source.remote.network

import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<RequestBody>

    // "https://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        //@Body user: User
    ): Response<RequestBody>
}