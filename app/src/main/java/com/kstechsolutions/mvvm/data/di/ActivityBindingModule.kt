package com.kstechsolutions.mvvm.data.di

import com.kstechsolutions.mvvm.modules.posts.PostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    internal abstract fun bindPostActivity(): PostActivity
}