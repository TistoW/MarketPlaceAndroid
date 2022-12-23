package com.inyongtisto.marketplace.core.data.source.model

data class Home(
    val categories: List<Category> = listOf(),
    val products: List<Product> = listOf(),
)