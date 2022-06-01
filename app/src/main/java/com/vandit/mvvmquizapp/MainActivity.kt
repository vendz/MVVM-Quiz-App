package com.vandit.mvvmquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vandit.mvvmquizapp.databinding.ActivityMainBinding
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.viewmodel.QuestionViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(QuestionViewModel::class.java)
        viewModel.addQuestion(QuestionsModel(0, "Question 1", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel(0, "Question 2", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel(0, "Question 3", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel(0, "Question 4", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel(0, "Question 5", "option b", "option a", "option b", "option c", "option d"))
    }
}