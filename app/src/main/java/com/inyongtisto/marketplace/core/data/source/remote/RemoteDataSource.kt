package com.inyongtisto.marketplace.core.data.source.remote

import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.network.ApiService
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.RegisterRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.util.getTokoId
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)

    suspend fun register(data: RegisterRequest) = api.register(data)

    suspend fun updateUser(data: UpdateProfileRequest) = api.updateUser(data.id, data)

    suspend fun uploadUser(id: Int? = null, fileImage: MultipartBody.Part? = null) =
        api.uploadUser(id, fileImage)

    suspend fun createToko(data: CreateTokoRequest) = api.createToko(data)

    suspend fun getUser(id: Int? = null) = api.getUser(id)

    suspend fun getAlamatToko() = api.getAlamatToko(getTokoId())
    suspend fun createAlamatToko(data: AlamatToko) = api.createAlamatToko(data)
    suspend fun updateAlamatToko(data: AlamatToko) = api.updateAlamatToko(data.id, data)
    suspend fun deleteAlamatToko(id: Int?) = api.deleteAlamatToko(id)

    suspend fun getProduct() = api.getProduct(getTokoId())
    suspend fun createProduct(data: Product) = api.createProduct(data)
    suspend fun updateProduct(data: Product) = api.updateProduct(data.id, data)
    suspend fun deleteProduct(id: Int?) = api.deleteProduct(id)
    suspend fun uploadProduct(fileImage: MultipartBody.Part? = null) = api.uploadProduct(fileImage)

    suspend fun getCategory() = api.getCategory()
    suspend fun createCategory(data: Category) = api.createCategory(data)
    suspend fun updateCategory(data: Category) = api.updateCategory(data.id, data)
    suspend fun deleteCategory(id: Int?) = api.deleteCategory(id)

}