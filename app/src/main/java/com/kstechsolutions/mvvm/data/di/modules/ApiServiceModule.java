package com.kstechsolutions.mvvm.data.di.modules;

import com.kstechsolutions.mvvm.modules.comments.data.CommentApiService;
import com.kstechsolutions.mvvm.modules.posts.data.PostApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiServiceModule {
    @Provides
    PostApiService providePostApiService() {
        return new PostApiService();
    }

    @Provides
    CommentApiService provideCommentApiService() {
        return new CommentApiService();
    }

}
