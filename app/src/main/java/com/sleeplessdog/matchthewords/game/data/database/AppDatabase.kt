package com.sleeplessdog.matchthewords.game.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sleeplessdog.matchthewords.game.data.WordEntity


@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}