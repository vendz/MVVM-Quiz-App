package com.vandit.mvvmquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vandit.mvvmquizapp.databinding.ActivityMainBinding
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.viewmodel.QuestionViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}