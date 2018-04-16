package com.kstechsolutions.mvvm.modules.base;

import android.support.annotation.StringRes;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public interface IBaseView {

    void showLoading(@StringRes int id);

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();
}