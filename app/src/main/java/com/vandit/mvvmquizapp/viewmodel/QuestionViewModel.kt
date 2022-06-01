package com.vandit.mvvmquizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vandit.mvvmquizapp.database.QuestionsDatabase
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.repository.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application): AndroidViewModel(application) {
    val allQuestion: LiveData<List<QuestionsModel>>
    val repository: QuestionsRepository
    val nextQuestion: LiveData<QuestionsModel>

    init {
        val dao = QuestionsDatabase.getDatabase(application).getQuestionsDao()
        repository = QuestionsRepository(dao)
        allQuestion = repository.allQuestions
        nextQuestion = dao.getNextQuestion()
    }

    fun addQuestion(question: QuestionsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(question)
    }

    fun updateQuestion(question: QuestionsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(question)
    }

    fun deleteQuestion(question: QuestionsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(question)
    }

    fun deleteAllQuestions() = viewModelScope.launch {
        repository.deleteAll()
    }
}