package pum.wmex1.mvvm_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import pum.wmex1.mvvm_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var wordViewModel: WordViewModel
    private lateinit var wordViewModelFactory: WordViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        wordViewModelFactory = WordViewModelFactory(Word("Zosia"))
        wordViewModel = ViewModelProvider(this, wordViewModelFactory).get(WordViewModel::class.java)
        binding.lifecycleOwner = this
        binding.wordFromView = wordViewModel
        Log.i("WordViewModel", "WordViewModel running")

    }
}