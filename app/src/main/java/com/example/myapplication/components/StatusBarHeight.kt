package com.example.myapplication.components

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun getStatusBarHeight(context: Context): Int {
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        (context.resources.getDimensionPixelSize(resourceId) / Resources.getSystem().displayMetrics.density).toInt()
    } else {
        0
    }
}

fun dpToPx(dp: Int): Int{
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}