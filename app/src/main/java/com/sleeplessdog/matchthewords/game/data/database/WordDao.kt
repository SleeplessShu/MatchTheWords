package com.sleeplessdog.matchthewords.game.data.database


import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.sleeplessdog.matchthewords.game.data.WordEntity
import com.sleeplessdog.matchthewords.game.domain.models.WordCategory


@Dao
interface WordDao {

    @Query("SELECT * FROM A1 WHERE category = :category COLLATE NOCASE LIMIT 36")
    suspend fun getWordsByCategory(category: WordCategory): List<WordEntity>

    @Query("SELECT * FROM A1 ORDER BY RANDOM() LIMIT :wordsNeeded")
    suspend fun getRandom(wordsNeeded: Int): List<WordEntity>




    @Update
    suspend fun updateWord(wordEntity: WordEntity)

}