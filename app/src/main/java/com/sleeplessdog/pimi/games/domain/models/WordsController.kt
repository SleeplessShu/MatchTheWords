package com.sleeplessdog.pimi.games.domain.models

import com.sleeplessdog.pimi.games.data.repository.WordsRepository
import com.sleeplessdog.pimi.games.presentation.models.Word
import com.sleeplessdog.pimi.settings.Language
import com.sleeplessdog.pimi.settings.LanguageLevel

class WordsController(
    private val repository: WordsRepository,
) {

    suspend fun getWordPairs(
        languageUi: Language,
        languageStudy: Language,
        levelWords: Set<LanguageLevel>,
        wordsNeeded: Int,
        categories: Set<String>,
    ): List<Pair<Word, Word>> {

        if (wordsNeeded <= 0) return emptyList()
        if (languageUi == languageStudy) return emptyList()

        return repository.getWordPairs(
            languageUi = languageUi,
            languageStudy = languageStudy,
            levelWords = levelWords,
            wordsNeeded = wordsNeeded,
            categories = categories
        )
    }
}
