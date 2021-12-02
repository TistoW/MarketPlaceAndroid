package com.inyongtisto.marketplace.core.data.source.remote.request

data class UpdateProfileRequest(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)