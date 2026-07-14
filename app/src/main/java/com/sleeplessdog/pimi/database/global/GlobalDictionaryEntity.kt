package com.sleeplessdog.pimi.database.global

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sleeplessdog.pimi.dictionary.group_screen.WordUi
import com.sleeplessdog.pimi.settings.Language
import com.sleeplessdog.pimi.settings.LanguageLevel

@Entity(tableName = "GlobalDictionary")
data class GlobalDictionaryEntity(
    @PrimaryKey
    val id: Long,
    val groupKey: String,
    val subGroupKey: String?,
    val difficulty: LanguageLevel,
    val isDeleted: Boolean,
    val english: String,
    val spanish: String?,
    val russian: String?,
    val french: String?,
    val german: String?,
    val armenian: String?,
    val serbian: String?,
    val armTranslit: String?,
    val georgian: String?,
    val georgianTranslit: String?,
    val kazakh: String?,
    val kazakhTranslit: String?,
)

fun GlobalDictionaryEntity.toUi(
    languageUi: Language,
    languageStudy: Language,
    useLatinScript: Boolean,
): WordUi {

    fun valueByLanguage(lang: Language): String =
        when (lang) {
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