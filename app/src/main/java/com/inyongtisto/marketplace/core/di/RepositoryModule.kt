package com.inyongtisto.marketplace.core.di

import com.inyongtisto.marketplace.core.data.repository.AlamatRepository
import com.inyongtisto.marketplace.core.data.repository.AppRepository
import com.inyongtisto.marketplace.core.data.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
    single { AlamatRepository(get(), get()) }
    single { ProductRepository(get(), get()) }
}