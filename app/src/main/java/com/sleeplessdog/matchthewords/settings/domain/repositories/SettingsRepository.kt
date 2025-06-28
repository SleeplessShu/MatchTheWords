package com.sleeplessdog.matchthewords.settings.domain.repositories

interface SettingsRepository {
    fun getThemeSettings(): Boolean
    fun setThemeSetting(currentStatus: Boolean)
}