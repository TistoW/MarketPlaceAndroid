package com.inyongtisto.marketplace.core.data.source.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Product(
    val id: Int? = null,
    val name: String?,
    val price: Int?,
    val tokoId: Int? = null,
    val categoryId: Int? = null,
    val description: String? = null,
    val wight: Int? = null,
    val stock: Int? = null,
    val isActive: Boolean? = null,
    val images: String? = null,
    val category: Category? = null,

    val pengirirman: String? = null,
    val terjual: Int? = null,
    val rating: Double? = null,
    val discount: Int? = null,
    val grosir: Boolean? = null,
    val imageDummy: Int? = null,  // nanti dihapus
) : Parcelable