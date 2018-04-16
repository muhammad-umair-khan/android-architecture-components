package com.kstechsolutions.mvvm.data.di.components;

import com.kstechsolutions.mvvm.data.di.modules.ActivityModule;
import com.kstechsolutions.mvvm.data.di.modules.ViewModelModule;
import com.kstechsolutions.mvvm.data.di.scopes.ActivityScope;
import com.kstechsolutions.mvvm.modules.comments.view.CommentListFragment;
import com.kstechsolutions.mvvm.modules.posts.view.PostListFragment;

import dagger.Component;


@ActivityScope
@Component(modules = {ActivityModule.class, ViewModelModule.class})
public interface ActivityComponent {
    void inject(PostListFragment fragment);
    void inject(CommentListFragment fragment);
}
