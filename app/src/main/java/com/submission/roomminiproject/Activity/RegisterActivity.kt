package com.submission.roomminiproject.Activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Model.Success
import com.submission.roomminiproject.Object.DialogSuccessObject
import com.submission.roomminiproject.Object.MessageUtil
import com.submission.roomminiproject.R
import com.submission.roomminiproject.ViewModel.RegisterViewModel
import com.submission.roomminiproject.databinding.ActivityRegisterBinding
import com.submission.roomminiproject.databinding.PopupSuccessRegistrasiBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mObject: DialogSuccessObject
    private val registerViewModel by viewModel<RegisterViewModel>()
    private var user: Register? = null
    private var text: Success?= null
    val bus: EventBus = EventBus.getDefault()
    private var position = 0


    companion object {
        const val EXTRA_NOTE = "extra_note"
        const val EXTRA_POSITION = "extra_position"
        const val RESULT_ADD = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bus.register(this)

        user = intent.getParcelableExtra(EXTRA_NOTE)
        if (user != null) {
            position = intent.getIntExtra(EXTRA_POSITION, 0)
        } else {
            user = Register()
        }

        binding?.btnSubmit?.setOnClickListener { view ->

            val username = binding.edtUsername.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            user.let { register ->
                register?.username = username
                register?.email = email
                register?.password = password
            }

            if (validateInput(user!!)) {
                MessageUtil.ToastMessage(applicationContext, "Fill all field")
            } else {
                    DialogSuccessObject.DialogSuccessObject(this@RegisterActivity).show()
                    text?.let { onMessageEvent(it) }
                    registerViewModel.insert(user as Register)
            }
        }

            binding?.btnLogin?.setOnClickListener {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        private fun validateInput(user: Register): Boolean {
            if (user.username?.isEmpty() == true || user.email?.isEmpty() == true || user.password?.isEmpty() == true) {
                return true
            }
            return false
        }

        @Subscribe
        fun onMessageEvent(success: Success){
            MessageUtil.ToastMessage(applicationContext,success.text)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    override fun onDestroy() {
        super.onDestroy()
        bus.unregister(this)
    }
}
