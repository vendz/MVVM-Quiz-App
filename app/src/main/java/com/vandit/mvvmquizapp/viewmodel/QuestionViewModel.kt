package com.vandit.mvvmquizapp.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vandit.mvvmquizapp.R
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
            nextQuestion.postValue(repository.getNextQuestion())
        }
    }

    fun verifyAnswer(v: View){
        viewModelScope.launch {
            nextQuestion.value?.apply {
                isAttempted = true
                if (v.id == R.id.option_a) {
                    if (answer == option_a) {
                        Log.d("TAG", "True")
                        isCorrect = true
                    } else {
                        Log.d("TAG", "False")
                    }
                } else if (v.id == R.id.option_b) {
                    if (answer == option_b) {
                        Log.d("TAG", "True")
                        isCorrect = true
                    } else {
                        Log.d("TAG", "False")
                    }
                } else if (v.id == R.id.option_c) {
                    if (answer == option_c) {
                        Log.d("TAG", "True")
                        isCorrect = true
                    } else {
                        Log.d("TAG", "False")
                    }
                } else if (v.id == R.id.option_d) {
                    if (answer == option_d) {
                        Log.d("TAG", "True")
                        isCorrect = true
                    } else {
                        Log.d("TAG", "False")
                    }
                }
            }?.let { updateQuestion(it) }
        }
    }

    fun getFirstQuestion() {
        viewModelScope.launch {
            nextQuestion.postValue(repository.getNextQuestion())
        }
    }
}