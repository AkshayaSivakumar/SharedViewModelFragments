package com.example.android.sharedviewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _userText = MutableLiveData<CharSequence>()
    val userText: LiveData<CharSequence>
        get() = _userText

    fun setUserText(text: CharSequence) {
        _userText.value = text
    }

}