package com.submission.roomminiproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.R
import com.submission.roomminiproject.ViewModel.LoginViewModel
import com.submission.roomminiproject.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel by viewModel<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding
    private var user: Register?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding?.btnSubmit?.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if(username == null || password == null){

            }else{


            }


        }

    }


}