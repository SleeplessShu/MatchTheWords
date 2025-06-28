package com.sleeplessdog.matchthewords.game.data.repositories

import com.sleeplessdog.matchthewords.game.data.WordEntity
import com.sleeplessdog.matchthewords.game.data.database.WordDao
import com.sleeplessdog.matchthewords.game.domain.models.LanguageLevel
import com.sleeplessdog.matchthewords.game.domain.models.WordCategory
import com.sleeplessdog.matchthewords.game.domain.repositories.DatabaseRepository
import com.sleeplessdog.matchthewords.game.presentation.models.Language


class DatabaseRepositoryImpl(private val wordDao: WordDao) : DatabaseRepository {

    override suspend fun getWordsPack(
        language1: Language,
        language2: Language,
        level: LanguageLevel,
        difficultLevel: Int,
        category: WordCategory
    ): List<WordEntity> {
        var dataBaseResponse = emptyList<WordEntity>()
        if (category == WordCategory.RANDOM) {
           dataBaseResponse = getRandom(difficultLevel)
        } else {
            dataBaseResponse = wordDao.getWordsByCategory(category)
            dataBaseResponse = adaptForConditions(dataBaseResponse, difficultLevel)
        }
        return dataBaseResponse
    }

    suspend fun getRandom(wordsNeeded: Int): List<WordEntity> {
        val additionalWords = wordDao.getRandom(wordsNeeded)
        return additionalWords
    }

    override suspend fun updateUsedWordsStatistic(wordEntity: WordEntity) {
        wordDao.updateWord(wordEntity)
    }


    private suspend fun adaptForConditions(
        dataBaseResponse: List<WordEntity>,
        difficultLevel: Int
    ): List<WordEntity> {

        // Перемешиваем элементы
        val shuffledList = dataBaseResponse.shuffled()

        return if (shuffledList.size >= difficultLevel) {
            // Если хватает слов, обрезаем до нужного количества
            shuffledList.take(difficultLevel)
        } else {
            // Если слов меньше, запрашиваем недостающие
            val missingCount = difficultLevel - shuffledList.size
            val additionalWords = getRandom(missingCount)

            // Объединяем текущие слова и недостающие
            (shuffledList + additionalWords).take(difficultLevel)
        }
    }



}