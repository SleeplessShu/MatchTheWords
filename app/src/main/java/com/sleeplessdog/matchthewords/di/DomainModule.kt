package com.sleeplessdog.matchthewords.di

import com.sleeplessdog.matchthewords.game.domain.api.DatabaseInteractor
import com.sleeplessdog.matchthewords.game.domain.api.GameInteractor
import com.sleeplessdog.matchthewords.game.domain.api.ScoreInteractor
import com.sleeplessdog.matchthewords.game.domain.interactors.DatabaseInteractorImpl
import com.sleeplessdog.matchthewords.game.domain.interactors.GameInteractorImpl
import com.sleeplessdog.matchthewords.game.domain.interactors.ScoreInteractorImpl
import com.sleeplessdog.matchthewords.settings.domain.api.SettingsInteractor
import com.sleeplessdog.matchthewords.settings.domain.api.SharingInteractor
import com.sleeplessdog.matchthewords.settings.domain.interactors.SettingsInteractorImpl
import com.sleeplessdog.matchthewords.settings.domain.interactors.SharingInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single<SharingInteractor> {
        SharingInteractorImpl(get(), get())
    }

    single<SettingsInteractor> {
        SettingsInteractorImpl(get())
    }

    single <DatabaseInteractor>{
        DatabaseInteractorImpl(get())
    }

    single <GameInteractor>{
       GameInteractorImpl(get())
    }

    single <ScoreInteractor> {
        ScoreInteractorImpl(get())
    }

}