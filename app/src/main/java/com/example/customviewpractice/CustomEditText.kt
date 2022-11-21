package com.example.customviewpractice

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class CustomEditText @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = R.style.CustomEditTextTheme) :
    ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var titleTextView: AppCompatTextView? = null
    private var customEditText: AppCompatEditText? = null
    private var startIconImageView: AppCompatImageView? = null

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.custom_edittext, this, true)
        titleTextView = findViewById(R.id.titleTextView)
        customEditText = findViewById(R.id.editText)
        startIconImageView = findViewById(R.id.startIconImageView)
        loadAttrs()
    }

    @DrawableRes
    var startIconResId: Int? = null
        set(value) {
            field = value
            value?.let {
                val drawable = ContextCompat.getDrawable(context, it)
                startIconImageView?.setImageDrawable(drawable)
                startIconImageView?.isVisible = true
            }
        }

    var title: String? = null
        set(value) {
            field = value
            value?.let {
                titleTextView?.text = it
            }
        }

    val text: String
        get() = customEditText?.text.toString()


    private fun loadAttrs() {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        title = a.getString(R.styleable.CustomTextView_android_title)
        startIconResId = a.getResourceId(R.styleable.CustomTextView_startIcon, -1)
        a.recycle()
    }
}