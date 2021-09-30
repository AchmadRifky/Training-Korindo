package com.submission.roomminiproject.Object

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object MessageUtil {
    fun ToastMessage(context: Context, message: String ){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun SnackBar(activity: Activity, message: String){
        val rootView = activity.window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }
}