package com.sleeplessdog.matchthewords

import android.content.Context
import android.os.Handler
import androidx.room.Room
import com.sleeplessdog.matchthewords.game.data.database.AppDatabase
import com.sleeplessdog.matchthewords.game.data.repositories.DatabaseRepositoryImpl
import com.sleeplessdog.matchthewords.game.data.repositories.ScoreRepositoryImpl
import com.sleeplessdog.matchthewords.game.domain.repositories.DatabaseRepository
import com.sleeplessdog.matchthewords.game.domain.repositories.ScoreRepository
import com.sleeplessdog.matchthewords.settings.data.ExternalNavigatorRepositoryImpl
import com.sleeplessdog.matchthewords.settings.data.SettingsRepositoryImpl
import com.sleeplessdog.matchthewords.settings.data.SharingRepositoryImpl
import com.sleeplessdog.matchthewords.settings.domain.repositories.ExternalNavigatorRepository
import com.sleeplessdog.matchthewords.settings.domain.repositories.SettingsRepository
import com.sleeplessdog.matchthewords.settings.domain.repositories.SharingRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    single(named("themePreferences")) {
        App.appContext.getSharedPreferences("NightMode", Context.MODE_PRIVATE)
    }
    single<SettingsRepository> {
        SettingsRepositoryImpl(get(named("themePreferences")))
    }
    single<SharingRepository> {
        SharingRepositoryImpl(get())
    }
    single<ExternalNavigatorRepository> {
        ExternalNavigatorRepositoryImpl(get())
    }
    single<DatabaseRepository> {
        DatabaseRepositoryImpl(get())
    }
    factory<Handler> {
        Handler()
    }
    single<Context> {
        App.appContext
    }
    single { get<AppDatabase>().wordDao() }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "dictionary.db"
        ).createFromAsset("databases/dictionary_new.db").build()
    }
    single (named("scoreStore")){
        App.appContext.getSharedPreferences("ScoreHistory", Context.MODE_PRIVATE)
    }
    single <ScoreRepository>{
        ScoreRepositoryImpl(get(named("scoreStore")), get())
    }

}