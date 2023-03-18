package com.example.arlibtest.di

import android.content.Context
import androidx.room.Room
import com.example.arlibtest.database.MedicationDao
import com.example.arlibtest.database.MedicationsRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MedicationsRoomDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MedicationsRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext, MedicationsRoomDatabase::class.java, "medications"
        ).build()
    }

    @Provides
    fun provideMedicationDao(appDatabase: MedicationsRoomDatabase): MedicationDao {
        return appDatabase.medicationDao()
    }
}