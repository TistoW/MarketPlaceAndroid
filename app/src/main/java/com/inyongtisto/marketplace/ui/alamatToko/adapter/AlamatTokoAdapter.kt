package com.inyongtisto.marketplace.ui.alamatToko.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.databinding.ItemAlamatTokoBinding
import com.inyongtisto.marketplace.databinding.ItemHomeCategoryBinding

@SuppressLint("NotifyDataSetChanged")
class AlamatTokoAdapter : RecyclerView.Adapter<AlamatTokoAdapter.ViewHolder>() {

    private var data = ArrayList<AlamatToko>()

    inner class ViewHolder(private val itemBinding: ItemAlamatTokoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: AlamatToko, position: Int) {
            itemBinding.apply {
                tvKota.text = item.kota
                var kecamatan = ""
                if (item.kecamatan != null) kecamatan = ", Kec. ${item.kecamatan}"

                tvAlamat.text =
                    "${item.alamat}$kecamatan, ${item.kota}, ${item.provinsi}, ${item.kodepost}"
                tvEmail.text = item.email
                tvPhone.text = item.phone
            }
        }
    }

    fun addItems(items: List<AlamatToko>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlamatTokoBinding.inflate(
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