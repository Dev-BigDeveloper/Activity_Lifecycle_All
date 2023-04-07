package com.example.activitylifecycleall.lifeCycle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.activitylifecycleall.R
import com.example.activitylifecycleall.databinding.ActivitySimpleState2Binding
import kotlin.properties.Delegates.notNull
import kotlin.random.Random

class SimpleState2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleState2Binding
    private var counterValue by notNull<Int>()
    private var counterTextColor by notNull<Int>()
    private var counterIsVisibility by notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { increment() }
        binding.randomColor.setOnClickListener { setRandomColor() }
        binding.switchVisibilityButton.setOnClickListener { switchVisibility() }

        if (savedInstanceState == null) {
            counterValue = 0
            counterTextColor = ContextCompat.getColor(this, R.color.purple_700)
            counterIsVisibility = true
        } else {
            counterValue = savedInstanceState.getInt(KEY_COUNTER)
            counterTextColor = savedInstanceState.getInt(KEY_COLOR)
            counterIsVisibility = savedInstanceState.getBoolean(KEY_IS_VISIBLE)
        }
        renderState()
    }

    private fun switchVisibility() {
        counterIsVisibility = !counterIsVisibility
        renderState()
    }

    private fun setRandomColor() {
        counterTextColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        renderState()
    }

    private fun increment() {
        counterValue++
        renderState()
    }

    private fun renderState() = with(binding) {
        counterTextView.text = counterValue.toString()
        counterTextView.setTextColor(counterTextColor)
        counterTextView.visibility = if (counterIsVisibility) View.VISIBLE else View.INVISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER,counterValue)
        outState.putInt(KEY_COLOR,counterTextColor)
        outState.putBoolean(KEY_IS_VISIBLE,counterIsVisibility)
    }

    companion object {
        @JvmStatic
        private val KEY_COUNTER = "COUNTER"
        @JvmStatic
        private val KEY_COLOR = "COLOR"
        @JvmStatic
        private val KEY_IS_VISIBLE = "IS_VISIBLE"
    }
}