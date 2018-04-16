package com.kstechsolutions.mvvm.data.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.kstechsolutions.mvvm.modules.base.ViewModelProviderFactory;
import com.kstechsolutions.mvvm.modules.comments.viewmodel.CommentViewModel;
import com.kstechsolutions.mvvm.modules.posts.viewmodel.PostListViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Provides
    PostListViewModel providePostListViewModel() {
        return new PostListViewModel();
    }

    @Provides
    CommentViewModel provideCommentViewModel() {
        return new CommentViewModel();
    }

    @Provides
    ViewModelProvider.Factory provideBlogViewModel(PostListViewModel postListViewModel) {
        return new ViewModelProviderFactory<>(postListViewModel);
    }

}
