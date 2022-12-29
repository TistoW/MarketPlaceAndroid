package com.inyongtisto.marketplace.ui.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.inyongtisto.marketplace.core.data.source.model.Slider
import com.inyongtisto.marketplace.databinding.ItemHomeSliderBinding
import com.inyongtisto.marketplace.databinding.ItemImageProductSliderBinding
import com.inyongtisto.marketplace.util.toUrlProduct
import com.inyongtisto.marketplace.util.toUrlSlider
import com.inyongtisto.myhelper.extension.setImagePicasso

class ImageProductSliderAdapter : PagerAdapter() {
    private val data: ArrayList<String> = ArrayList()

    override fun getCount() = data.size

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    fun addItems(items: List<String>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding =
            ItemImageProductSliderBinding.inflate(
                LayoutInflater.from(container.context),
                container,
                false
            )
        val item = data[position]

        binding.apply {
            imageProduct.setImagePicasso(item.toUrlProduct())
        }

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}