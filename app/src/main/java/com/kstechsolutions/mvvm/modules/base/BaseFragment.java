package com.kstechsolutions.mvvm.modules.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.data.di.components.ActivityComponent;
import com.kstechsolutions.mvvm.data.di.components.DaggerActivityComponent;
import com.kstechsolutions.mvvm.data.di.modules.ActivityModule;
import com.kstechsolutions.mvvm.utils.DialogHelper;
import com.kstechsolutions.mvvm.utils.NetworkUtils;
import com.kstechsolutions.mvvm.utils.ToastManager;

import butterknife.Unbinder;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public abstract class BaseFragment extends Fragment implements IBaseView {
    private ActivityComponent mActivityComponent;
    private Context mContext;
    private Unbinder mUnBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(mContext))
                .build();
    }

    protected ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    protected void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading(int id) {
        hideLoading();
        DialogHelper.showLoadingDialog(mContext, id);
    }

    @Override
    public void hideLoading() {
        DialogHelper.hideProgressDialog();
    }

    @Override
    public void onError(String message) {
        if (message != null && message.length() > 0)
            ToastManager.showShortToast(mContext, message);
        else onError(R.string.err_nodata);
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        ToastManager.showShortToast(mContext, message);
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }


    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mContext);
    }
}
