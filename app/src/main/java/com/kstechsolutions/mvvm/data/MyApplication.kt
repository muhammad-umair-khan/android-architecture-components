package com.kstechsolutions.mvvm.data

import com.kstechsolutions.mvvm.data.di.base.DaggerAppComponent
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()
}