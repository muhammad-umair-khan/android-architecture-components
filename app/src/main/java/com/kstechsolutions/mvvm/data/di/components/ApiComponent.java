package com.kstechsolutions.mvvm.data.di.components;

import com.kstechsolutions.mvvm.data.di.modules.ApiModule;
import com.kstechsolutions.mvvm.modules.comments.data.CommentApiService;
import com.kstechsolutions.mvvm.modules.posts.data.PostApiService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(PostApiService client);
    void inject(CommentApiService client);
}