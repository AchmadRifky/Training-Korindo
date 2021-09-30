package com.submission.roomminiproject.Object

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.submission.roomminiproject.Activity.LoginActivity
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.Model.Register
import com.submission.roomminiproject.Model.Success
import com.submission.roomminiproject.databinding.PopupSuccessRegistrasiBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


object DialogSuccessObject : AppCompatActivity(){
    private lateinit var dialogBinding: PopupSuccessRegistrasiBinding
    val bus: EventBus = EventBus.getDefault()



    fun DialogSuccessObject(activity: AppCompatActivity) : Dialog {
        val dialog_popup = Dialog(activity)
//        dialog_popup.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding = PopupSuccessRegistrasiBinding.inflate(activity.layoutInflater)
        val view = dialogBinding.root
        dialog_popup.setContentView(view)
        dialog_popup.window?.setGravity(Gravity.CENTER)
        dialog_popup.setCancelable(false)

        val lp_popup = WindowManager.LayoutParams()
        lp_popup.width = WindowManager.LayoutParams.MATCH_PARENT
        lp_popup.height = WindowManager.LayoutParams.MATCH_PARENT

        dialogBinding.btnOkay.setOnClickListener {
            dialog_popup.dismiss()
            bus.post(Success("Register Success"))
        }
        return dialog_popup
    }


}