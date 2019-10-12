package com.kstechsolutions.mvvm.data.di.base

import com.kstechsolutions.mvvm.data.MyApplication
import com.kstechsolutions.mvvm.data.di.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    ViewModelModule::class,
    NetworkModule::class])

@Singleton
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }
}

