package com.inyongtisto.marketplace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.marketplace.databinding.FragmentHomeBinding
import com.inyongtisto.marketplace.ui.home.adapter.CategoryAdapter
import com.inyongtisto.marketplace.ui.home.adapter.ProductTerbaruAdapter
import com.inyongtisto.marketplace.ui.home.adapter.ProductTerlarisAdapter
import com.inyongtisto.marketplace.ui.home.adapter.SliderAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapterCategory = CategoryAdapter()
    private val adapterSlider = SliderAdapter()

    private val adapterProductTerlaris = ProductTerlarisAdapter()
    private val adapterProductTerbaru = ProductTerbaruAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        return root
    }

    private fun setupAdapter() {
        binding.rvCategory.adapter = adapterCategory
        binding.rvSlider.adapter = adapterSlider
        binding.rvProductTerlaris.adapter = adapterProductTerlaris
        binding.rvProductTerbaru.adapter = adapterProductTerbaru
    }

    private fun setData() {
        viewModel.listCategory.observe(requireActivity(), {
            adapterCategory.addItems(it)
        })

        viewModel.listSlider.observe(requireActivity(), {
            adapterSlider.addItems(it)
        })

        viewModel.listProduct.observe(requireActivity(), {
            adapterProductTerlaris.addItems(it)
            adapterProductTerbaru.addItems(it)
        })
    }

    fun mainButton() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}