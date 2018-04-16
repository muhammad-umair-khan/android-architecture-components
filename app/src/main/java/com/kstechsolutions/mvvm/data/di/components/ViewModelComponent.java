package com.kstechsolutions.mvvm.data.di.components;

import com.kstechsolutions.mvvm.data.di.modules.ApiServiceModule;
import com.kstechsolutions.mvvm.modules.comments.viewmodel.CommentViewModel;
import com.kstechsolutions.mvvm.modules.posts.viewmodel.PostListViewModel;

import dagger.Component;

@Component(modules = ApiServiceModule.class)
public interface ViewModelComponent {
    void inject(PostListViewModel viewModel);
    void inject(CommentViewModel viewModel);
}
