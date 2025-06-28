package com.sleeplessdog.matchthewords.settings.domain.api

interface SettingsInteractor {
    fun getThemeSettings(): Boolean
    fun setThemeSetting(currentStatus: Boolean)
}
