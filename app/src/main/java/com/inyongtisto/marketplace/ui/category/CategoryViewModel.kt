package com.inyongtisto.marketplace.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inyongtisto.marketplace.core.data.repository.CategoryRepository
import com.inyongtisto.marketplace.core.data.source.model.Category

class CategoryViewModel(private val repo: CategoryRepository) : ViewModel() {
    fun get() = repo.getCategory().asLiveData()
    fun create(data: Category) = repo.createCategory(data).asLiveData()
    fun update(data: Category) = repo.updateCategory(data).asLiveData()
    fun delete(id: Int?) = repo.deleteCategory(id).asLiveData()
}