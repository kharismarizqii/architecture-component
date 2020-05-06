package com.kharismarizqii.livedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel(){
    private var number: MutableLiveData<String> = MutableLiveData()

    fun getNumber(): MutableLiveData<String> {
        return number
    }

    fun createNumber(){
        val random = Random()
        val text = "Number, ${random.nextInt(10 - 1) + 1}"
        number.value = text
    }
}