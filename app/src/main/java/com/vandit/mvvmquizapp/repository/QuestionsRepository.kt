package com.vandit.mvvmquizapp.repository

import androidx.lifecycle.LiveData
import com.vandit.mvvmquizapp.database.QuestionsDao
import com.vandit.mvvmquizapp.models.QuestionsModel

class QuestionsRepository(private val questionsDao: QuestionsDao) {
    val allQuestions: LiveData<List<QuestionsModel>> = questionsDao.getAllQuestions()
    val nextQuestion: LiveData<QuestionsModel> = questionsDao.getNextQuestion()

    suspend fun insert(questionsModel: QuestionsModel){
        questionsDao.insertQuestion(questionsModel)
    }

    suspend fun delete(questionsModel: QuestionsModel){
        questionsDao.deleteQuestion(questionsModel)
    }

    suspend fun update(questionsModel: QuestionsModel){
        questionsDao.updateQuestion(questionsModel)
    }

    suspend fun deleteAll(){
        questionsDao.deleteAllQuestions()
    }
}