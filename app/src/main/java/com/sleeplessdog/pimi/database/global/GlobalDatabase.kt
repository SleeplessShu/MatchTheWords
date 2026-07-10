package com.sleeplessdog.pimi.database.global

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sleeplessdog.pimi.utils.ConstantsPaths.ASSETS_DATABASE_DICTIONARY_PATH
import com.sleeplessdog.pimi.utils.ConstantsPaths.GLOBAL_DATABASE_DICTIONARY_NAME


@Database(
    entities = [GlobalDictionaryEntity::class], version = 3, exportSchema = false
)
@TypeConverters(GlobalDbConverters::class)
abstract class GlobalDatabase : RoomDatabase() {

    abstract fun globalDao(): GlobalDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE GlobalDictionary ADD COLUMN armTranslit TEXT"
                )
            }
        }
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE GlobalDictionary ADD COLUMN georgian TEXT")
                database.execSQL("ALTER TABLE GlobalDictionary ADD COLUMN georgianTranslit TEXT")
                database.execSQL("ALTER TABLE GlobalDictionary ADD COLUMN kazakh TEXT")
                database.execSQL("ALTER TABLE GlobalDictionary ADD COLUMN kazakhTranslit TEXT")
            }
        }

        fun create(context: Context): GlobalDatabase = Room.databaseBuilder(
            context, GlobalDatabase::class.java, GLOBAL_DATABASE_DICTIONARY_NAME
        ).createFromAsset(
            ASSETS_DATABASE_DICTIONARY_PATH, object : RoomDatabase.PrepackagedDatabaseCallback() {
                override fun onOpenPrepackagedDatabase(db: SupportSQLiteDatabase) {
                    listOf(
                        "armTranslit TEXT",
                        "georgian TEXT",
                        "georgianTranslit TEXT",
                        "kazakh TEXT",
                        "kazakhTranslit TEXT"
                    ).forEach { columnDef ->
                        try {
                            db.execSQL("ALTER TABLE GlobalDictionary ADD COLUMN $columnDef")
                        } catch (e: Exception) {
                            Log.d("GlobalDatabase", "Column already exists: $columnDef")
                        }
                    }
                }
            }).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
    }
}
