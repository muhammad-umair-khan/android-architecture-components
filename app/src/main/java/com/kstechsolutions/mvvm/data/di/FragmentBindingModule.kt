package com.kstechsolutions.mvvm.data.di

import com.kstechsolutions.mvvm.modules.comments.CommentListFragment
import com.kstechsolutions.mvvm.modules.posts.PostListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    internal abstract fun bindPostListFragment(): PostListFragment

    @ContributesAndroidInjector
    internal abstract fun bindCommentListFragment(): CommentListFragment
}