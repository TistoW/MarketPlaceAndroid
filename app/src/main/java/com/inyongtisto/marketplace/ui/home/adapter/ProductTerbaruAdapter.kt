package com.inyongtisto.marketplace.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.databinding.ItemHomeProdukTerbaruBinding
import com.inyongtisto.marketplace.util.toUrlProduct
import com.inyongtisto.myhelper.extension.*

@SuppressLint("NotifyDataSetChanged")
class ProductTerbaruAdapter : RecyclerView.Adapter<ProductTerbaruAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukTerbaruBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Product, position: Int) {
            itemBinding.apply {
                val harga = item.price ?: 0
                tvName.text = item.name
                imageView.setImagePicasso(item.firstImage().toUrlProduct())
                tvHarga.text = item.price.toRupiah()
                tvPengiriman.text = item.pengirirman ?: "Jakarta Pusat"
                tvReting.text = "" + (item.rating.def(5.0)) + " | Terjual " + item.sold

                if (item.discount != 0) {
                    lyGrosir.toGone()
                    val discount = item.discount.toDouble()
                    lyDiskon.visible(discount > 0)
                    tvDiscount.text = "${item.discount}%"
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
            ItemHomeProdukTerbaruBinding.inflate(
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