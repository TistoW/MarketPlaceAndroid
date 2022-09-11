package com.inyongtisto.marketplace.ui.product.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.databinding.ItemGambarBinding
import com.inyongtisto.marketplace.databinding.ItemHomeCategoryBinding
import com.inyongtisto.marketplace.util.toUrlProduct
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.setImagePicasso
import com.inyongtisto.myhelper.extension.visible

@SuppressLint("NotifyDataSetChanged")
class AddImageAdapter(
    var onAddImage: () -> Unit,
    var onDeleteImage: (Int) -> Unit
) :
    RecyclerView.Adapter<AddImageAdapter.ViewHolder>() {

    var data = ArrayList<String>()

    inner class ViewHolder(private val itemBinding: ItemGambarBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: String, position: Int) {
            itemBinding.apply {

                logs("Gambar:$item - ${item.toUrlProduct()}")
                if (item.isNotEmpty()) {
                    btnAddFoto.setImagePicasso(item.toUrlProduct())
                } else btnAddFoto.setImageResource(R.drawable.asset_addphotos)

                btnClose.visible(item.isNotEmpty())
                btnAddFoto.setOnClickListener {
                    onAddImage.invoke()
                }

                btnClose.setOnClickListener {
                    onDeleteImage.invoke(adapterPosition)
                }
            }
        }
    }

    fun addItems(items: List<String>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun removeAt(index: Int) {
        data.removeAt(index)
        notifyItemRemoved(index)
    }

    fun allNotEmpty() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGambarBinding.inflate(
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