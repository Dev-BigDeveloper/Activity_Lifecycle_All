package com.example.activitylifecycleall.lifeCycle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activitylifecycleall.databinding.ActivitySimpleState1Binding
import kotlin.random.Random

class SimpleState1Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleState1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener {
            increment()
        }

        binding.randomColor.setOnClickListener {
            setRandomColor()
        }

        binding.switchVisibilityButton.setOnClickListener {
            switchVisibility()
        }
//        if (savedInstanceState == null) {
//            counterValue = 0;
//            counterTextColor = ContextCompat.getColor(this, R.color.purple_700)
//            counterIsVisibility = true
//        } else {
//            counterValue = savedInstanceState.getInt(KEY_COUNTER)
//        }
    }

    private fun switchVisibility() = with(binding.counterTextView) {
        visibility = if (visibility == View.VISIBLE)
            View.INVISIBLE
        else
            View.VISIBLE
    }

    private fun setRandomColor() {
        val randomColor = Color.rgb (
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        binding.counterTextView.setTextColor(randomColor)
    }

    private fun increment() {
        var counter = binding.counterTextView.text.toString().toInt()
        counter ++
        binding.counterTextView.text = counter.toString()
    }
}