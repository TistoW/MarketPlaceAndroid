package com.inyongtisto.marketplace.core.data.repository

import com.inyongtisto.marketplace.core.data.source.local.LocalDataSource
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.RemoteDataSource
import com.inyongtisto.marketplace.core.data.source.remote.network.Resource
import com.inyongtisto.marketplace.util.defaultError
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import java.lang.Exception

class ProductRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun getProduct() = flow {
        emit(Resource.loading(null))
        try {
            remote.getProduct().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.data

                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.defaultError(), null))
        }
    }

    fun createProduct(data: Product) = flow {
        emit(Resource.loading(null))
        try {
            remote.createProduct(data).let {
                if (it.isSuccessful) {
                    val body = it.body()?.data
                    emit(Resource.success(body))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.defaultError(), null))
        }
    }

    fun updateProduct(data: Product) = flow {
        emit(Resource.loading(null))
        try {
            remote.updateProduct(data).let {
                if (it.isSuccessful) {
                    val body = it.body()?.data
                    emit(Resource.success(body))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.defaultError(), null))
        }
    }

    fun deleteProduct(id: Int?) = flow {
        emit(Resource.loading(null))
        try {
            remote.deleteProduct(id).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.data
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.defaultError(), null))
        }
    }

    fun upload(fileImage: MultipartBody.Part? = null) = flow {
        emit(Resource.loading(null))
        try {
            remote.uploadProduct(fileImage).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val fileName = body?.data
                    emit(Resource.success(fileName))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.defaultError(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.defaultError(), null))
        }
    }
}