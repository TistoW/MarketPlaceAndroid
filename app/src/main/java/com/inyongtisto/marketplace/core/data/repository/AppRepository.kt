package com.inyongtisto.marketplace.core.data.repository

import com.inyongtisto.marketplace.core.data.source.local.LocalDataSource
import com.inyongtisto.marketplace.core.data.source.remote.RemoteDataSource
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.myhelper.extension.logs
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun login(data: LoginRequest) = flow {
        try {
            remote.login(data).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    emit(body)
                    logs("succes:" + body.toString())
                } else {
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception) {
            logs("login: error yg di handel:" + e.message)
        }
    }

}