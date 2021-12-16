package com.inyongtisto.marketplace.core.data.source.remote.network

import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.RegisterRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.core.data.source.remote.response.BaseResponse
import com.inyongtisto.marketplace.core.data.source.remote.response.LoginResponse
import com.inyongtisto.marketplace.core.data.source.remote.response.ProductResponse
import com.inyongtisto.marketplace.core.data.source.remote.response.TokoResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    // "https://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ): Response<LoginResponse>

    @PUT("update-user/{id}")
    suspend fun updateUser(
        @Path("id") int: Int,
        @Body data: UpdateProfileRequest
    ): Response<LoginResponse>

    @Multipart
    @POST("upload-user/{id}")
    suspend fun uploadUser(
        @Path("id") int: Int? = null,
        @Part data: MultipartBody.Part? = null
    ): Response<LoginResponse>

    @POST("toko")
    suspend fun createToko(
            @Body data: CreateTokoRequest
    ): Response<BaseResponse<TokoResponse>>

    @POST("product")
    suspend fun createProduct(
            @Body data: CreateTokoRequest
    ): Response<BaseResponse<ProductResponse>>
}