package com.vandit.mvvmquizapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionsTable")
data class QuestionsModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val question: String?,
    var answer: String?,
    var option_a: String?,
    var option_b: String?,
    var option_c: String?,
    var option_d: String?
)