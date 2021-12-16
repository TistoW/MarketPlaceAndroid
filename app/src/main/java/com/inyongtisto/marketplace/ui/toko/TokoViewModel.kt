package com.inyongtisto.marketplace.ui.toko

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.AppRepository
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.RegisterRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import okhttp3.MultipartBody

class TokoViewModel(val repo: AppRepository) : ViewModel() {
    fun createToko(data: CreateTokoRequest) = repo.createToko(data).asLiveData()
}