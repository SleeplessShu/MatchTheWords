package com.sleeplessdog.pimi.database.user

import com.sleeplessdog.pimi.dictionary.group_screen.WordUi
import com.sleeplessdog.pimi.settings.Language

data class WordProjection(
    val id: Long,
    val english: String?,
    val spanish: String?,
    val russian: String?,
    val french: String?,
    val german: String?,
    val armenian: String?,
    val serbian: String?,
    val georgian: String?,
    val kazakh: String?,
    val armTranslit: String?,
    val georgianTranslit: String?,
    val kazakhTranslit: String?,
)

fun WordProjection.toUi(
    languageUi: Language,
    languageStudy: Language,
    useLatinScript: Boolean,
): WordUi {
    fun valueByLanguage(lang: Language): String = when (lang) {
        Language.ENGLISH -> english
        Language.SPANISH -> spanish
        Language.RUSSIAN -> russian
        Language.FRENCH -> french
        Language.GERMAN -> german
        Language.ARMENIAN -> if (useLatinScript) armTranslit ?: armenian else armenian
        Language.SERBIAN -> serbian
        Language.GEORGIAN -> if (useLatinScript) georgianTranslit ?: georgian else georgian
        Language.KAZAKH -> if (useLatinScript) kazakhTranslit ?: kazakh else kazakh
    } ?: ""

    return WordUi(
        id = id,
        word = valueByLanguage(languageStudy),
        translation = valueByLanguage(languageUi)
    )
}