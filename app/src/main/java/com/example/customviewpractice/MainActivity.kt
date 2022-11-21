package com.example.customviewpractice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        val customEditText: CustomEditText = findViewById(R.id.customEditText)
        customEditText.title = "Hello"
        customEditText.startIconResId = R.mipmap.ic_launcher

        btn.setOnClickListener {
            customEditText.title = customEditText.text
        }

    }
}