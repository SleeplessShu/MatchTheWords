package com.sleeplessdog.matchthewords.settings.domain.repositories

import com.sleeplessdog.matchthewords.settings.domain.models.EmailData

interface ExternalNavigatorRepository {
    fun shareLink(text: String)
    fun openLink(link: String)
    fun openEmail(email: EmailData)
}