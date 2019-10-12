package com.kstechsolutions.mvvm.data.di

import com.kstechsolutions.mvvm.modules.comments.CommentApi
import com.kstechsolutions.mvvm.modules.posts.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

@Module class NetworkModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton @Provides fun postApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Singleton @Provides fun commentApi(retrofit: Retrofit): CommentApi {
        return retrofit.create(CommentApi::class.java)
    }
}
