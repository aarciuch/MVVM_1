package pum.wmex1.mvvm_1

import android.util.Log
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WordViewModel(private val w: Word) : ViewModel() {
    var a: Word = w
    public var word1: MutableLiveData<String> = MutableLiveData<String>()
    set(value) {
        word1.value = field.toString()
    }
    val _word1 : LiveData<String>
        get() = word1


    init {
        Log.i("WordViewModel", "WordViewModel created")
        word1.value = a.word
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("WordViewModel", "WordViewModel destroyed")
    }
}

class WordViewModelFactory(private val w: Word) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(w) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}