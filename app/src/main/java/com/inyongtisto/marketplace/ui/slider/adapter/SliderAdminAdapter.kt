package com.inyongtisto.marketplace.ui.slider.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.core.data.source.model.Slider
import com.inyongtisto.marketplace.databinding.ItemSliderAdminBinding
import com.inyongtisto.marketplace.util.toUrlSlider
import com.inyongtisto.myhelper.extension.*

@SuppressLint("NotifyDataSetChanged")
class SliderAdminAdapter(
    val onClick: (item: Slider) -> Unit,
    val onDelete: (item: Slider, pos: Int) -> Unit
) : RecyclerView.Adapter<SliderAdminAdapter.ViewHolder>() {

    private var data = ArrayList<Slider>()

    inner class ViewHolder(private val itemBinding: ItemSliderAdminBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Slider, position: Int) {
            itemBinding.apply {
                val context = root.context
                tvName.text = item.name

                val imageName = item.image
                imageView.setImagePicasso(imageName.toUrlSlider())

                btnEdit.setOnClickListener {
                    onClick.invoke(item)
                }

                lyMain.setOnClickListener {
                    onClick.invoke(item)
                }

                btnDelete.setOnClickListener {
                    onDelete.invoke(item, adapterPosition)
                }
            }
        }
    }

    fun removeAt(index: Int) {
        data.removeAt(index)
        notifyItemRemoved(index)
    }

    fun addItems(items: List<Slider>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSliderAdminBinding.inflate(
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