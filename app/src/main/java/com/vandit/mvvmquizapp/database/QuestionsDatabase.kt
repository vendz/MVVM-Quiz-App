package com.vandit.mvvmquizapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vandit.mvvmquizapp.models.QuestionsModel

@Database(entities = [QuestionsModel::class], version = 1, exportSchema = false)
abstract class QuestionsDatabase: RoomDatabase() {
    abstract fun getQuestionsDao(): QuestionsDao

    companion object {
        @Volatile
        private var INSTANCE: QuestionsDatabase? = null

        fun getDatabase(context: Context): QuestionsDatabase {
            return INSTANCE?: synchronized(this) {
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    QuestionsDatabase::class.java,
                    "questions_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}