package com.dicoding.picodiploma.mycomputershopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("About Creator")
        setContentView(R.layout.activity_about)
    }
}