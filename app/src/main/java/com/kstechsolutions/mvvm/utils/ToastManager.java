package com.kstechsolutions.mvvm.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class ToastManager {

    private static Toast mToast;

    public static void showShortToast(Context context, String msg) {
        try {
            if (mToast != null)
                mToast.cancel();
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            mToast.show();
        } catch (Exception ignored) {
        }
    }
}
