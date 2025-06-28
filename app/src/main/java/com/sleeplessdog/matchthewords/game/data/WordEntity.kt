package com.sleeplessdog.matchthewords.game.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "A1")
data class WordEntity(
    @PrimaryKey val id: Int,
    val level: String,
    val category: String,
    val correct: Int,
    val mistake: Int,
    val date: String,
    val english: String,
    val spanish: String,
    val russian: String,
    val french: String,
    val german: String
)