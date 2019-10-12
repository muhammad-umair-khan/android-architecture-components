package com.kstechsolutions.mvvm.data.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kstechsolutions.mvvm.data.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: MyApplication) = app.applicationContext

    fun provideResourceProvider(context: Context)= ResourceProvider(context)

    @Singleton
    @Provides
    fun providePreference(context: Context)= PreferenceManager.getDefaultSharedPreferences(context)

    @Singleton
    @Provides
    fun providePreferenceEditor(preferences: SharedPreferences)= preferences.edit()
}
