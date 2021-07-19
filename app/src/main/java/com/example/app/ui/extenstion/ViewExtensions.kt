package com.example.app.ui.extenstion

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showShortToast(@StringRes message: Int) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
