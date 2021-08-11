package com.example.daggerhilt.di

import com.example.daggerhilt.data.LoggerDataSource
import com.example.daggerhilt.data.LoggerLocalDataSource
import com.example.daggerhilt.data.LoggerMemoryDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerDatabaseModule {

    @Binds
    @DataBaseLogger
    @Singleton
    abstract fun provideDataBaseLogger(inLocalLogger: LoggerLocalDataSource) : LoggerDataSource
}

@Module
@InstallIn(ActivityComponent::class)
abstract class LoggerMemoryModule {

    @Binds
    @InMemoryLogger
    @ActivityScoped
    abstract fun provideInMemoryLogger(inMemoryLogger: LoggerMemoryDataSource) : LoggerDataSource
}

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DataBaseLogger