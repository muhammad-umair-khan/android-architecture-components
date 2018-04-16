/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.kstechsolutions.mvvm.modules.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.kstechsolutions.mvvm.data.di.components.DaggerViewModelComponent;
import com.kstechsolutions.mvvm.data.di.components.ViewModelComponent;
import com.kstechsolutions.mvvm.data.di.modules.ApiServiceModule;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class BaseViewModel<V extends IBaseView> extends ViewModel {
    private CompositeDisposable mCompositeDisposable;
    private final ViewModelComponent mViewModelComponent;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private V mView;

    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
        mViewModelComponent = DaggerViewModelComponent.builder()
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    protected ViewModelComponent getViewModelComponent() {
        return mViewModelComponent;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        mView = null;
        super.onCleared();
    }

    protected CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    protected V getView() {
        return mView;
    }

    public void setView(V view) {
        this.mView = view;
    }
}
