package com.inyongtisto.marketplace.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.ProductRepository
import com.inyongtisto.marketplace.core.data.source.model.Product
import okhttp3.MultipartBody

class ProductViewModel(private val repo: ProductRepository) : ViewModel() {
    fun get() = repo.getProduct().asLiveData()
    fun create(data: Product) = repo.createProduct(data).asLiveData()
    fun update(data: Product) = repo.updateProduct(data).asLiveData()
    fun delete(id: Int?) = repo.deleteProduct(id).asLiveData()

    fun upload(fileImage: MultipartBody.Part? = null) = repo.upload(fileImage).asLiveData()
}