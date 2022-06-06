package com.vandit.mvvmquizapp.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.vandit.mvvmquizapp.models.QuestionsModel

@Dao
interface QuestionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionsModel)

    @Update
    suspend fun updateQuestion(question: QuestionsModel)

    @Delete
    suspend fun deleteQuestion(question: QuestionsModel)

    @Query("SELECT * FROM questionsTable")
    fun getAllQuestions(): LiveData<List<QuestionsModel>>

    @Query("SELECT * FROM questionsTable WHERE isAttempted = 0 ORDER by id LIMIT 1")
    suspend fun getNextQuestion(): QuestionsModel

    @Query("DELETE FROM questionsTable")
    suspend fun deleteAllQuestions()
}