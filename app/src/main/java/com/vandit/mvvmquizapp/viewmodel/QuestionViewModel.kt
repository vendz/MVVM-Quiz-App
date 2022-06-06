package com.vandit.mvvmquizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vandit.mvvmquizapp.database.QuestionsDatabase
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.repository.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    val allQuestion: LiveData<List<QuestionsModel>>
    val repository: QuestionsRepository
    val nextQuestion: MutableLiveData<QuestionsModel> = MutableLiveData()

    init {
        val dao = QuestionsDatabase.getDatabase(application).getQuestionsDao()
        repository = QuestionsRepository(dao)
        allQuestion = repository.allQuestions
    }

    suspend fun addQuestion(question: QuestionsModel) = repository.insert(question)

    suspend fun updateQuestion(question: QuestionsModel) = repository.update(question)

    fun deleteQuestion(question: QuestionsModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(question)
    }

    fun deleteAllQuestions() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    fun getNextQuestion() {
        viewModelScope.launch {
            nextQuestion.value?.apply {
                isAttempted = true
            }?.let { updateQuestion(it) }
            nextQuestion.postValue(repository.getNextQuestion())
        }
    }

    fun getFirstQuestion() {
        viewModelScope.launch {
            nextQuestion.postValue(repository.getNextQuestion())
        }
    }
}