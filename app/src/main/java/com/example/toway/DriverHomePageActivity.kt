package com.example.toway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toway.databinding.ActivityDriverHomepageBinding

class DriverHomePageActivity: AppCompatActivity() {
    private val view: ActivityDriverHomepageBinding by lazy {
        ActivityDriverHomepageBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_homepage)
        setContentView(view.root)


    }
}