package com.inyongtisto.marketplace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.FragmentHomeBinding
import com.inyongtisto.marketplace.ui.home.adapter.CategoryAdapter
import com.inyongtisto.marketplace.ui.home.adapter.ProductTerbaruAdapter
import com.inyongtisto.marketplace.ui.home.adapter.ProductTerlarisAdapter
import com.inyongtisto.marketplace.ui.home.adapter.SliderAdapter
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.toJson
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapterCategory = CategoryAdapter()
    private val adapterSlider = SliderAdapter()

    private val adapterProductTerlaris = ProductTerlarisAdapter()
    private val adapterProductTerbaru = ProductTerbaruAdapter()
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        getHome()
        return root
    }

    private fun setupAdapter() {
        binding.rvCategory.adapter = adapterCategory
        binding.rvSlider.adapter = adapterSlider
        binding.rvProductTerlaris.adapter = adapterProductTerlaris
        binding.rvProductTerbaru.adapter = adapterProductTerbaru
    }

    private fun setData() {
        viewModel.listCategory.observe(requireActivity()) {

        }

        viewModel.listSlider.observe(requireActivity()) {
            adapterSlider.addItems(it)
        }

        viewModel.listProduct.observe(requireActivity()) {
//            adapterProductTerbaru.addItems(it)
        }
    }

    private fun getHome() {
        viewModel.getHome().observe(requireActivity()) {
            when (it.state) {
                State.SUCCESS -> {
                    logs("HomeData:" + it.data.toJson())
                    val categories = it.data?.categories ?: listOf()
                    val products = it.data?.products ?: listOf()
                    adapterCategory.addItems(categories)
                    adapterProductTerlaris.addItems(products)
                    adapterProductTerbaru.addItems(products)
                }
                State.ERROR -> {
                }
                State.LOADING -> {
                }
            }
        }
    }

    fun mainButton() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}