package com.example.retrofitanecdotecrud.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitanecdotecrud.entity.Anecdote

@Database(entities = [Anecdote::class], version = 1)
abstract class AnecdoteDatabase : RoomDatabase() {

    abstract fun getAnecdoteDao(): AnecdoteDao

    companion object {
        var database: AnecdoteDatabase? = null

        fun getDatabase(application: Application): AnecdoteDatabase? {
            if (database == null) {
                database = Room.databaseBuilder(
                    application.applicationContext,
                    AnecdoteDatabase::class.java,
                    "anecdote_database"
                ).build()
            }
            return database
        }
    }
}