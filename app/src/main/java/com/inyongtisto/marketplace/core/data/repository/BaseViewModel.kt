package com.inyongtisto.marketplace.core.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.ProductRepository
import com.inyongtisto.marketplace.core.data.source.model.Product
import okhttp3.MultipartBody

class BaseViewModel(private val repo: AppRepository) : ViewModel() {
    fun upload(path: String, fileImage: MultipartBody.Part? = null) =
        repo.uploadImage(path, fileImage).asLiveData()
}