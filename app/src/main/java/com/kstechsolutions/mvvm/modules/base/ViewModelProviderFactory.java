package com.kstechsolutions.mvvm.modules.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {

    private final V viewModel;

    public ViewModelProviderFactory(V viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public <V extends ViewModel> V create(Class<V> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())) {
            return (V) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
