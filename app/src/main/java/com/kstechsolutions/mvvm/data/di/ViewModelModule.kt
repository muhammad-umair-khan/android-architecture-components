package com.kstechsolutions.mvvm.data.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kstechsolutions.mvvm.data.di.base.ViewModelFactory
import com.kstechsolutions.mvvm.data.di.base.ViewModelKey
import com.kstechsolutions.mvvm.modules.comments.CommentListViewModel
import com.kstechsolutions.mvvm.modules.posts.PostListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    internal abstract fun postListViewModel(viewModel: PostListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentListViewModel::class)
    internal abstract fun commentListViewModel(viewModel: CommentListViewModel): ViewModel
}