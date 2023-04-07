package com.example.activitylifecycleall.lifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitylifecycleall.R
import com.example.activitylifecycleall.databinding.ActivitySimpleState4Binding

class SimpleState4Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleState4Binding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState4Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}