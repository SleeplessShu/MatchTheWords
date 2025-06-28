package com.sleeplessdog.matchthewords

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.room.Room
import com.sleeplessdog.matchthewords.di.domainModule
import com.sleeplessdog.matchthewords.di.presentationModule
import com.sleeplessdog.matchthewords.game.data.database.AppDatabase
import com.sleeplessdog.matchthewords.settings.domain.api.SettingsInteractor

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.java.KoinJavaComponent.getKoin



class App : Application() {
    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
        Log.d("DEBUG", "onCreate: ${appContext.getDatabasePath("dictionary_new.db")}")
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, presentationModule)
        }
        //copyDatabaseFromAssets(appContext)
        deleteExistingDatabase(appContext, "dictionary.db")
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "dictionary_new.db"  // Название локальной базы данных
        )
            .createFromAsset("databases/dictionary_new.db")
            .build()




        val settingsInteractor: SettingsInteractor = getKoin().get()
        val isNightModeOn = settingsInteractor.getThemeSettings()
        AppCompatDelegate.setDefaultNightMode(
            if (isNightModeOn) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )

    }
    fun deleteExistingDatabase(context: Context, dbName: String) {
        val dbPath = context.getDatabasePath(dbName)
        if (dbPath.exists()) {
            dbPath.delete()
            Log.d("Database", "Старая база данных удалена.")
        }
    }


    companion object {

        lateinit var database: AppDatabase
        lateinit var appContext: Context
            private set
    }
}