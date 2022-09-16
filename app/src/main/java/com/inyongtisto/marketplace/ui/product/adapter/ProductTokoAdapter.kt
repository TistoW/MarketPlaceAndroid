package com.inyongtisto.marketplace.ui.product.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.model.User
import com.inyongtisto.marketplace.databinding.ItemAlamatTokoBinding
import com.inyongtisto.marketplace.databinding.ItemHomeCategoryBinding
import com.inyongtisto.marketplace.databinding.ItemProductTokoBinding
import com.inyongtisto.marketplace.ui.alamatToko.EditAlamatTokoActivity
import com.inyongtisto.marketplace.util.toUrlProduct
import com.inyongtisto.myhelper.extension.*
import com.squareup.picasso.Picasso
import java.time.Instant
import kotlin.math.log

@SuppressLint("NotifyDataSetChanged")
class ProductTokoAdapter(
    val onClick: (item: Product) -> Unit,
    val onDelete: (item: Product, pos: Int) -> Unit
) : RecyclerView.Adapter<ProductTokoAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    inner class ViewHolder(private val itemBinding: ItemProductTokoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Product, position: Int) {
            itemBinding.apply {
                val context = root.context
                tvName.text = item.name
                tvHarga.text = item.price.toRupiah()
                tvStok.text = item.stock.toString()

                val splitImages = item.images?.split("|")
                val imageProduct = if (splitImages.isNullOrEmpty()) {
                    item.images ?: ""
                } else {
                    splitImages[0]
                }

                imgProduct.setImagePicasso(imageProduct.toUrlProduct())

                btnEdit.setOnClickListener {
                    logs("cek this button")
                    onClick.invoke(item)
                }

                lyMain.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }

    fun removeAt(index: Int) {
        data.removeAt(index)
        notifyItemRemoved(index)
    }

    fun addItems(items: List<Product>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductTokoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}