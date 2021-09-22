package com.submission.roomminiproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.submission.roomminiproject.Database.ArticleRoomDatabase
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.R
import com.submission.roomminiproject.Repository.RegisterRepository
import com.submission.roomminiproject.ViewModel.RegisterViewModel
import com.submission.roomminiproject.databinding.ActivityRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity(){

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel by viewModel<RegisterViewModel>()
    private var user:Register?= null
    private var position = 0


    companion object{
        const val EXTRA_NOTE = "extra_note"
        const val EXTRA_POSITION = "extra_position"
        const val RESULT_ADD = 101
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra(EXTRA_NOTE)
        if(user != null){
            position = intent.getIntExtra(EXTRA_POSITION,0)
        }else{
            user = Register()
        }

        binding?.btnSubmit?.setOnClickListener { view->

                val username = binding.edtUsername.text.toString().trim()
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()

                user.let { register->
                    register?.username = username
                    register?.email = email
                    register?.password = password
                }

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtra(EXTRA_NOTE, user)
                intent.putExtra(EXTRA_POSITION, position)
                startActivity(intent)
                registerViewModel.insert(user as Register)
                setResult(RESULT_ADD, intent)
            }
        }
    }

