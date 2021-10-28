package com.inyongtisto.marketplace.core.data.source.remote

import com.inyongtisto.marketplace.core.data.source.remote.network.ApiService
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest

class RemoteDataSource(private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)

}