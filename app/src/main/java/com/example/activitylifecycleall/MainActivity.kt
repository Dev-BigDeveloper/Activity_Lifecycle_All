package com.example.activitylifecycleall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitylifecycleall.databinding.ActivityMainBinding
import com.example.activitylifecycleall.lifeCycle.SimpleState1Activity
import com.example.activitylifecycleall.lifeCycle.SimpleState2Activity
import com.example.activitylifecycleall.lifeCycle.SimpleState3Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simple1.setOnClickListener {
            val intent = Intent(this,SimpleState1Activity::class.java).also {
                startActivity(it)
            }

        }

        binding.simple2.setOnClickListener {
            val intent = Intent(this,SimpleState2Activity::class.java)
            startActivity(intent)
        }

        binding.simple3.setOnClickListener {
            val intent = Intent(this,SimpleState3Activity::class.java)
            startActivity(intent)
        }

    }
}