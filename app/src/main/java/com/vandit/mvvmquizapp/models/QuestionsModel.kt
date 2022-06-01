package com.vandit.mvvmquizapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionsTable")
data class QuestionsModel (
    val question: String?,
    var answer: String?,
    var option_a: String?,
    var option_b: String?,
    var option_c: String?,
    var option_d: String?,
    var isCorrect: Boolean? = false,
    var isAttempted: Boolean? = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    override fun toString(): String {
        return "$question $answer"
    }
}