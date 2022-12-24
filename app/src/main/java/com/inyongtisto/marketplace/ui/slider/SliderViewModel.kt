package com.inyongtisto.marketplace.ui.slider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.CategoryRepository
import com.inyongtisto.marketplace.core.data.repository.SliderRepository
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.remote.request.CategoryRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.SliderRequest

class SliderViewModel(private val repo: SliderRepository) : ViewModel() {
    fun get() = repo.getSlider().asLiveData()
    fun create(data: SliderRequest) = repo.createSlider(data).asLiveData()
    fun update(data: SliderRequest) = repo.updateSlider(data).asLiveData()
    fun delete(id: Int?) = repo.deleteSlider(id).asLiveData()
}