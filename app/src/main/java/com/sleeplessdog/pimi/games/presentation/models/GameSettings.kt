package com.sleeplessdog.pimi.games.presentation.models

import com.sleeplessdog.pimi.games.domain.models.WordsGroupsList
import com.sleeplessdog.pimi.settings.DifficultyLevel
import com.sleeplessdog.pimi.settings.Language
import com.sleeplessdog.pimi.settings.LanguageLevel

data class GameSettings(
    val languageUi: Language = Language.RUSSIAN,
    val languageStudy: Language = Language.SPANISH,
    val levelWords: Set<LanguageLevel> = setOf(LanguageLevel.A1),
    val levelDifficulty: DifficultyLevel = DifficultyLevel.MEDIUM,
    val category: Set<String> = setOf(WordsGroupsList.RANDOM.toString()),
)

