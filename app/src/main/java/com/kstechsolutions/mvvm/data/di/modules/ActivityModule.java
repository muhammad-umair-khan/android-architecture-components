package com.kstechsolutions.mvvm.data.di.modules;

import android.content.Context;

import com.kstechsolutions.mvvm.modules.posts.adapter.PostListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    PostListAdapter providePostListAdapter() {
        return new PostListAdapter(mContext);
    }

}
