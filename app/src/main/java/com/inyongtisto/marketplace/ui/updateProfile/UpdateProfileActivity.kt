package com.inyongtisto.marketplace.ui.updateProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.databinding.ActivityUpdateProfileBinding
import com.inyongtisto.marketplace.ui.auth.AuthViewModel
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateProfileActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityUpdateProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar, "Update Profile")

        mainButton()
        setData()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                edtName.setText(user.name)
                edtEmail.setText(user.email)
                edtPhone.setText(user.phone)
            }
        }
    }

    private fun mainButton() {
        binding.btnSimpan.setOnClickListener {
            register()
        }
    }

    private fun register() {

        if (binding.edtName.isEmpty()) return
        if (binding.edtPhone.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return

        val body = UpdateProfileRequest(
            1,
            binding.edtName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPhone.text.toString()
        )

//        viewModel.register(body).observe(this, {
//
//            when (it.state) {
//                State.SUCCESS -> {
////                    dismisLoading()
//                    showToast("Selamat datang " + it.data?.name)
//                    pushActivity(NavigationActivity::class.java)
//                }
//                State.ERROR -> {
////                    dismisLoading()
//                    toastError(it.message ?: "Error")
//                }
//                State.LOADING -> {
////                    showLoading()
//                }
//            }
//        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}