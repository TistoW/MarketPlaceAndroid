package com.inyongtisto.marketplace.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.databinding.ActivityLoginBinding
import com.inyongtisto.marketplace.databinding.FragmentDashboardBinding
import com.inyongtisto.marketplace.util.Prefs
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModel()

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        viewModel.text.observe(this, {
            binding.edtEmail.setText(it)
        })

        binding.btnMasuk.setOnClickListener {

            val body = LoginRequest(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )

            viewModel.login(body).observe(this, {

            })
        }
    }


}