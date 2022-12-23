package com.inyongtisto.marketplace.core.data.repository

import com.inyongtisto.marketplace.core.data.source.local.LocalDataSource
import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.remote.RemoteDataSource
import com.inyongtisto.marketplace.core.data.source.remote.network.Resource
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.RegisterRequest
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.marketplace.util.defaultError
import com.inyongtisto.myhelper.extension.getErrorBody
import com.inyongtisto.myhelper.extension.logs
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import java.lang.Exception

class AlamatRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun getAlamatToko() = flow {
        emit(Resource.loading(null))
        try {
            remote.getAlamatToko().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.data
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }

    fun createAlamatToko(data: AlamatToko) = flow {
        emit(Resource.loading(null))
        try {
            remote.createAlamatToko(data).let {
                if (it.isSuccessful) {
                    val body = it.body()?.data
                    emit(Resource.success(body))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }

    fun updateAlamatToko(data: AlamatToko) = flow {
        emit(Resource.loading(null))
        try {
            remote.updateAlamatToko(data).let {
                if (it.isSuccessful) {
                    val body = it.body()?.data
                    emit(Resource.success(body))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }

    fun deleteAlamatToko(id: Int?) = flow {
        emit(Resource.loading(null))
        try {
            remote.deleteAlamatToko(id).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.data

                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Terjadi Kesalahan", null))
        }
    }
}