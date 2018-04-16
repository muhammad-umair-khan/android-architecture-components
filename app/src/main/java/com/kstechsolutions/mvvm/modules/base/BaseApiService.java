package com.kstechsolutions.mvvm.modules.base;

import com.kstechsolutions.mvvm.data.di.components.ApiComponent;
import com.kstechsolutions.mvvm.data.di.components.DaggerApiComponent;
import com.kstechsolutions.mvvm.data.di.modules.ApiModule;
/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class BaseApiService {
    private final ApiComponent mApiComponent;

    public BaseApiService() {
        mApiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    protected ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
