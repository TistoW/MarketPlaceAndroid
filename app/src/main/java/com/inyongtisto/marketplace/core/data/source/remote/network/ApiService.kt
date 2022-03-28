package com.inyongtisto.marketplace.core.data.source.remote.network

import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.RegisterRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.core.data.source.remote.response.*
import okhttp3.MultipartBody
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
    ): Response<BaseSingelResponse<TokoResponse>>

    @POST("product")
    suspend fun createProduct(
        @Body data: CreateTokoRequest
    ): Response<BaseSingelResponse<ProductResponse>>

    @GET("toko-user/{id}")
    suspend fun getUser(
        @Path("id") int: Int? = null
    ): Response<LoginResponse>

    @GET("alamat-toko/{id}")
    suspend fun getAlamatToko(
        @Path("id") idToko: Int? = null
    ): Response<BaseListResponse<AlamatToko>>

    @POST("alamat-toko")
    suspend fun createAlamatToko(
        @Body data: AlamatToko
    ): Response<BaseSingelResponse<AlamatToko>>
}