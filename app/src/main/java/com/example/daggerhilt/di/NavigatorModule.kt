package com.example.daggerhilt.di

import com.example.daggerhilt.navigator.AppNavigator
import com.example.daggerhilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigatorModule {
    @Binds
    abstract fun provideNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}