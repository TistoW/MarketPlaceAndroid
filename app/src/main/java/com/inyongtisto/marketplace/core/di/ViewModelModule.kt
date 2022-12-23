package com.inyongtisto.marketplace.core.di

import com.inyongtisto.marketplace.core.data.repository.BaseViewModel
import com.inyongtisto.marketplace.ui.alamatToko.AlamatTokoViewModel
import com.inyongtisto.marketplace.ui.auth.AuthViewModel
import com.inyongtisto.marketplace.ui.category.CategoryViewModel
import com.inyongtisto.marketplace.ui.home.HomeViewModel
import com.inyongtisto.marketplace.ui.navigation.NavViewModel
import com.inyongtisto.marketplace.ui.product.ProductViewModel
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { TokoViewModel(get()) }
    viewModel { NavViewModel(get()) }
    viewModel { AlamatTokoViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { BaseViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}