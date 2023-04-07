package com.example.activitylifecycleall.lifeCycle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.activitylifecycleall.R
import com.example.activitylifecycleall.databinding.ActivitySimpleState3Binding
import java.io.Serializable
import kotlin.random.Random

class SimpleState3Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleState3Binding

    private lateinit var state:State

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleState3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { increment() }
        binding.randomColor.setOnClickListener { setRandomColor() }
        binding.switchVisibilityButton.setOnClickListener { switchVisibility() }

        state = if (savedInstanceState == null) {
            State(
                counterValue = 0,
                counterTextColor = ContextCompat.getColor(this,R.color.teal_700),
                counterIsVisibility = true
            )
        } else {
            savedInstanceState.getSerializable(KEY_STATE) as State
        }
        renderState()
    }

    private fun switchVisibility() {
        state.counterIsVisibility = !state.counterIsVisibility
        renderState()
    }

    private fun setRandomColor() {
        state.counterTextColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        renderState()
    }

    private fun increment() {
        state.counterValue ++
        renderState()
    }

    private fun renderState() = with(binding) {
        counterTextView.text = state.counterValue.toString()
        counterTextView.setTextColor(state.counterTextColor)
        counterTextView.visibility = if (state.counterIsVisibility) View.VISIBLE else View.INVISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_STATE,state)
    }

    class State (
        var counterValue: Int,
        var counterTextColor: Int,
        var counterIsVisibility: Boolean) : Serializable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
    }

}