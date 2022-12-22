package com.inyongtisto.marketplace.core.data.source.model

import android.os.Parcelable
import com.inyongtisto.marketplace.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int? = null,
    val parentId: Int? = null,
    val name: String? = null,
    val image: String? = null,
    val imageDummy: Int = R.drawable.asset_komputer,
) : Parcelable