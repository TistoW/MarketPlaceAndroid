package com.inyongtisto.marketplace.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Slider
import com.inyongtisto.marketplace.databinding.ItemHomeCategoryBinding
import com.inyongtisto.marketplace.databinding.ItemHomeSliderBinding

@SuppressLint("NotifyDataSetChanged")
class SliderAdapter : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    private var data = ArrayList<Slider>()

    inner class ViewHolder(private val itemBinding: ItemHomeSliderBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Slider, position: Int) {
            itemBinding.apply {
                imageView.setImageResource(item.image)
            }
        }
    }

    fun addItems(items: List<Slider>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeSliderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}