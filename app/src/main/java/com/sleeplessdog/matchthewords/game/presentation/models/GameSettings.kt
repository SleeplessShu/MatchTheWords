package com.sleeplessdog.matchthewords.game.presentation.models

import com.sleeplessdog.matchthewords.game.domain.models.LanguageLevel
import com.sleeplessdog.matchthewords.game.domain.models.WordCategory

data class GameSettings(
    val language1: Language = Language.RUSSIAN,
    val language2: Language = Language.SPANISH,
    val level: LanguageLevel = LanguageLevel.A1,
    val category: WordCategory = WordCategory.RANDOM,
    val difficult: DifficultLevel = DifficultLevel.MEDIUM
)

