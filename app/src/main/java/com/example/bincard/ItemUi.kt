package com.example.bincard

import android.widget.TextView


data class ItemUi(
    private val text: String
) {
    fun show(textView: TextView) = textView.setText(text)
    fun getText(): String = text
}