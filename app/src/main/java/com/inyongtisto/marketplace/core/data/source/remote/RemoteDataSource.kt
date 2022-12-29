package com.inyongtisto.marketplace.core.data.source.remote

import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.network.ApiService
import com.inyongtisto.marketplace.core.data.source.remote.request.*
import com.inyongtisto.marketplace.util.getTokoId
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    /*********** Auth *************/
    suspend fun login(data: LoginRequest) = api.login(data)
    suspend fun register(data: RegisterRequest) = api.register(data)
    suspend fun updateUser(data: UpdateProfileRequest) = api.updateUser(data.id, data)
    suspend fun uploadUser(id: Int? = null, fileImage: MultipartBody.Part? = null) =
        api.uploadUser(id, fileImage)

    suspend fun createToko(data: CreateTokoRequest) = api.createToko(data)
    suspend fun getUser(id: Int? = null) = api.getUser(id)

    /*********** Alamat *************/
    suspend fun getAlamatToko() = api.getAlamatToko(getTokoId())
    suspend fun createAlamatToko(data: AlamatToko) = api.createAlamatToko(data)
    suspend fun updateAlamatToko(data: AlamatToko) = api.updateAlamatToko(data.id, data)
    suspend fun deleteAlamatToko(id: Int?) = api.deleteAlamatToko(id)

    /*********** Product *************/
    suspend fun getProduct() = api.getProduct(getTokoId())
    suspend fun createProduct(data: Product) = api.createProduct(data)
    suspend fun updateProduct(data: Product) = api.updateProduct(data.id, data)
    suspend fun deleteProduct(id: Int?) = api.deleteProduct(id)
    suspend fun getOneProduct(id: Int?) = api.getOneProduct(id)
    suspend fun uploadProduct(fileImage: MultipartBody.Part? = null) = api.uploadProduct(fileImage)

    /*********** Category *************/
    suspend fun getCategory() = api.getCategory()
    suspend fun createCategory(data: CategoryRequest) = api.createCategory(data)
    suspend fun updateCategory(data: CategoryRequest) = api.updateCategory(data.id, data)
    suspend fun deleteCategory(id: Int?) = api.deleteCategory(id)

    /*********** Slider *************/
    suspend fun getSlider() = api.getSlider()
    suspend fun createSlider(data: SliderRequest) = api.createSlider(data)
    suspend fun updateSlider(data: SliderRequest) = api.updateSlider(data.id, data)
    suspend fun deleteSlider(id: Int?) = api.deleteSlider(id)

    suspend fun uploadImage(path: String, fileImage: MultipartBody.Part? = null) =
        api.uploadImage(path, fileImage)

    suspend fun getHome() = api.getHome()

}