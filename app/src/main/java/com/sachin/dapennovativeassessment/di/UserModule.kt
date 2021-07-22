package com.sachin.dapennovativeassessment.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sachin.dapennovativeassessment.db.UserDatabase
import com.sachin.dapennovativeassessment.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, UserDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(
        userDatabase: UserDatabase
    ) = userDatabase.getDao()

}