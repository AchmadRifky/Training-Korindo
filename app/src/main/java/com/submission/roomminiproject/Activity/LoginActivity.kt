package com.submission.roomminiproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.R
import com.submission.roomminiproject.Repository.RegisterRepository
import com.submission.roomminiproject.ViewModel.LoginViewModel
import com.submission.roomminiproject.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel by viewModel<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding?.btnSubmit?.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all field", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel?.getUsername(username, password)?.observe(this,{
                    val listResult = ArrayList<Register>()
                    listResult.addAll(it)
                    when(listResult.size){
                        0 -> Toast.makeText(this, "username tidak dikenal", Toast.LENGTH_SHORT).show()
                        else -> {
                            //pindah ke acitivity lain
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                })
            }
        }

        binding?.btnRegister?.setOnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}