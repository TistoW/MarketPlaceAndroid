package com.inyongtisto.marketplace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.FragmentHomeBinding
import com.inyongtisto.marketplace.ui.home.adapter.*
import com.inyongtisto.myhelper.extension.*
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

        setupSlider()
        setupAdapter()
        setData()
        mainButton()
        getHome()

        return root
    }

    fun mainButton() {
        binding.apply {
            swipeRefresh.setDefaultColor()
            swipeRefresh.setOnRefreshListener {
                getHome()
            }
        }
    }

    private fun setupAdapter() {
        binding.rvCategory.adapter = adapterCategory
        binding.rvProductTerlaris.adapter = adapterProductTerlaris
        binding.rvProductTerbaru.adapter = adapterProductTerbaru
    }

    private fun setData() {

    }

    private fun setupSlider() {
        binding.apply {
            slider.adapter = adapterSlider
            slider.setPadding(40, 0, 40, 0)
        }
    }

    private fun getHome() {
        viewModel.getHome().observe(requireActivity()) {
            when (it.state) {
                State.SUCCESS -> {
                    binding.apply {
                        pdCategory.toGone()
                        pdSlider.toGone()
                        pdProductTerbaru.toGone()
                        pdProductTerlaris.toGone()
                        swipeRefresh.isRefreshing = false
                    }

                    val categories = it.data?.categories ?: listOf()
                    val products = it.data?.products ?: listOf()
                    val sliders = it.data?.sliders ?: listOf()

                    adapterCategory.addItems(categories)
                    adapterProductTerlaris.addItems(products)
                    adapterProductTerbaru.addItems(products)
                    adapterSlider.addItems(sliders)
                }
                State.ERROR -> {
                }
                State.LOADING -> {

                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}