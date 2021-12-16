package com.inyongtisto.marketplace.core.di

import com.inyongtisto.marketplace.ui.auth.AuthViewModel
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { TokoViewModel(get()) }
}