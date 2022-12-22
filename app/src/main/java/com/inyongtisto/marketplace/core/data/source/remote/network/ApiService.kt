package com.inyongtisto.marketplace.core.data.source.remote.network

import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.request.*
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

    @PUT("alamat-toko/{id}")
    suspend fun updateAlamatToko(
        @Path("id") id: Int? = null,
        @Body data: AlamatToko
    ): Response<BaseSingelResponse<AlamatToko>>

    @DELETE("alamat-toko/{id}")
    suspend fun deleteAlamatToko(
        @Path("id") id: Int? = null
    ): Response<BaseSingelResponse<AlamatToko>>

    @GET("product/{id}")
    suspend fun getProduct(
        @Path("id") idToko: Int? = null
    ): Response<BaseListResponse<Product>>

    @POST("product")
    suspend fun createProduct(
        @Body data: Product
    ): Response<BaseSingelResponse<Product>>

    @PUT("product/{id}")
    suspend fun updateProduct(
        @Path("id") id: Int? = null,
        @Body data: Product
    ): Response<BaseSingelResponse<Product>>

    @DELETE("product/{id}")
    suspend fun deleteProduct(
        @Path("id") id: Int? = null
    ): Response<BaseSingelResponse<Product>>

    @Multipart
    @POST("upload/product")
    suspend fun uploadProduct(
        @Part data: MultipartBody.Part? = null
    ): Response<BaseSingelResponse<String>>

    @GET("category")
    suspend fun getCategory(): Response<BaseListResponse<Category>>

    @POST("category")
    suspend fun createCategory(
        @Body data: CategoryRequest
    ): Response<BaseSingelResponse<Category>>

    @PUT("category/{id}")
    suspend fun updateCategory(
        @Path("id") id: Int? = null,
        @Body data: CategoryRequest
    ): Response<BaseSingelResponse<Category>>

    @DELETE("category/{id}")
    suspend fun deleteCategory(
        @Path("id") id: Int? = null
    ): Response<BaseSingelResponse<Category>>

    @Multipart
    @POST("upload/{path}")
    suspend fun uploadImage(
        @Path("path") id: String? = null,
        @Part data: MultipartBody.Part? = null
    ): Response<BaseSingelResponse<String>>
}