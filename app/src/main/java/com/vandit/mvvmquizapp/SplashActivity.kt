package com.vandit.mvvmquizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vandit.mvvmquizapp.databinding.ActivitySplashBinding
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.viewmodel.QuestionViewModel

class SplashActivity : AppCompatActivity() {
    lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(QuestionViewModel::class.java)
        viewModel.deleteAllQuestions()
        viewModel.addQuestion(QuestionsModel("Question 1", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel("Question 2", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel("Question 3", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel("Question 4", "option b", "option a", "option b", "option c", "option d"))
        viewModel.addQuestion(QuestionsModel("Question 5", "option b", "option a", "option b", "option c", "option d"))

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}