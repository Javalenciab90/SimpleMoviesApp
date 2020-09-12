package com.java90.simplemoviesapp.domain.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

fun ProgressBar.showProgressBar() {
    this.visibility = View.VISIBLE
}

fun ProgressBar.hideProgressBar() {
    this.visibility = View.GONE
}

fun TextView.hideLoadingMessage() {
    this.visibility = View.GONE
}

fun TextView.showLoadingMessage() {
    this.visibility = View.VISIBLE
}


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}