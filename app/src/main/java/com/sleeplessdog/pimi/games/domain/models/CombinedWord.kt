package com.sleeplessdog.pimi.games.domain.models

data class CombinedWord(
    val globalId: Long?,
    val userWordId: Long?,
    val english: String?,
    val spanish: String?,
    val russian: String?,
    val french: String?,
    val german: String?,
    val armenian: String?,
    val serbian: String?,
    val armTranslit: String? = null,
    val georgian: String?,
    val georgianTranslit: String? = null,
    val kazakh: String?,
    val kazTranslit: String? = null,
)
