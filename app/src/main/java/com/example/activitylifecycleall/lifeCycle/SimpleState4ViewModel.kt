package com.example.activitylifecycleall.lifeCycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleState4ViewModel : ViewModel() {
    val state:LiveData<SimpleState3Activity.State> get() = stateLiveData
    private val stateLiveData = MutableLiveData<SimpleState3Activity.State>()

    fun intiState(state:SimpleState3Activity.State) {
        stateLiveData.value = state
    }

    fun increment() {
        val oldState = stateLiveData.value
        stateLiveData.value = oldState
    }

    fun setRandomColor() {
        val oldState = stateLiveData.value
    }
}