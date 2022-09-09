package com.inyongtisto.marketplace.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.databinding.ItemHomeProdukTerlarisBinding
import com.inyongtisto.myhelper.extension.coret
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toRupiah
import com.inyongtisto.myhelper.extension.toVisible

@SuppressLint("NotifyDataSetChanged")
class ProductTerlarisAdapter : RecyclerView.Adapter<ProductTerlarisAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukTerlarisBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Product, position: Int) {
            itemBinding.apply {
                val harga = item.price ?: 0
                tvName.text = item.name
                imageView.setImageResource(item.imageDummy ?: R.drawable.asset_produk1)
                tvHarga.text = item.price.toRupiah()
                tvPengiriman.text = item.pengirirman
                tvReting.text = "" + item.rating + " | Terjual" + item.terjual

                if (item.discount != 0) {
                    lyGrosir.toGone()
                    lyDiskon.toVisible()
                    tvDiscount.text = "${item.discount}%"
                    val discount = item.discount?.toDouble() ?: 0.0
                    tvHarga.text = (harga - ((discount / 100) * harga)).toRupiah()
                    tvHargaAsli.text = item.price.toRupiah()
                    tvHargaAsli.coret()
                }
            }
        }
    }

    fun addItems(items: List<Product>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeProdukTerlarisBinding.inflate(
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