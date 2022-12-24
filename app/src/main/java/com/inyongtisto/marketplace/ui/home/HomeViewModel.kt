package com.inyongtisto.marketplace.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.AppRepository
import com.inyongtisto.marketplace.core.data.repository.ProductRepository
import com.inyongtisto.marketplace.core.data.source.local.DummyData
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.model.Slider
import java.util.*

class HomeViewModel(private val repo: AppRepository) : ViewModel() {
    fun getHome() = repo.getHome().asLiveData()
}