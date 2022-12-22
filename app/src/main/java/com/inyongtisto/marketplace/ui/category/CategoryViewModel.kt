package com.inyongtisto.marketplace.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.CategoryRepository
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.remote.request.CategoryRequest

class CategoryViewModel(private val repo: CategoryRepository) : ViewModel() {
    fun get() = repo.getCategory().asLiveData()
    fun create(data: CategoryRequest) = repo.createCategory(data).asLiveData()
    fun update(data: CategoryRequest) = repo.updateCategory(data).asLiveData()
    fun delete(id: Int?) = repo.deleteCategory(id).asLiveData()
}