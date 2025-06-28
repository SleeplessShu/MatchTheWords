package com.sleeplessdog.matchthewords.game.domain.interactors

import com.sleeplessdog.matchthewords.game.data.WordEntity
import com.sleeplessdog.matchthewords.game.domain.api.DatabaseInteractor
import com.sleeplessdog.matchthewords.game.domain.models.LanguageLevel
import com.sleeplessdog.matchthewords.game.domain.models.WordCategory
import com.sleeplessdog.matchthewords.game.domain.repositories.DatabaseRepository
import com.sleeplessdog.matchthewords.game.presentation.models.Language


class DatabaseInteractorImpl(private val database: DatabaseRepository): DatabaseInteractor {
    override suspend fun getWordsPack(language1: Language,
                                      language2: Language,
                                      level: LanguageLevel,
                                      difficultLevel: Int,
                                      category: WordCategory
    ): List<WordEntity> {
        return database.getWordsPack(
            language1, language2, level, difficultLevel, category)
    }

    override suspend fun updateWord(wordEntity: WordEntity){
        database.updateUsedWordsStatistic(wordEntity)
    }
}