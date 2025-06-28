package com.sleeplessdog.matchthewords.settings.domain.interactors

import com.sleeplessdog.matchthewords.settings.domain.api.SettingsInteractor
import com.sleeplessdog.matchthewords.settings.domain.repositories.SettingsRepository


class SettingsInteractorImpl(private val settings: SettingsRepository) :
    SettingsInteractor {

    override fun getThemeSettings(): Boolean {
        return settings.getThemeSettings()
    }

    override fun setThemeSetting(currentStatus: Boolean) {
        settings.setThemeSetting(currentStatus)
    }

}