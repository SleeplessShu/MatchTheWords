package com.sleeplessdog.matchthewords.settings.domain.repositories

import com.sleeplessdog.matchthewords.settings.domain.models.EmailData


interface SharingRepository {
    fun getShareAppLink(): String
    fun getSupportEmailData(): EmailData
    fun getTermsLink(): String
}