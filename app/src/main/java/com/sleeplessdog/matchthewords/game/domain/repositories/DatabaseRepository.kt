package com.sleeplessdog.matchthewords.game.domain.repositories

import com.sleeplessdog.matchthewords.game.data.WordEntity
import com.sleeplessdog.matchthewords.game.domain.models.LanguageLevel
import com.sleeplessdog.matchthewords.game.domain.models.WordCategory
import com.sleeplessdog.matchthewords.game.presentation.models.Language


interface DatabaseRepository {
    suspend fun getWordsPack(
        language1: Language,
        language2: Language,
        level: LanguageLevel,
        difficultLevel: Int,
        category: WordCategory
    ): List<WordEntity>

    suspend fun updateUsedWordsStatistic(wordEntity: WordEntity)
}
