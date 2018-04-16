package com.kstechsolutions.mvvm.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class DialogHelper {
    private static ProgressDialog mProgressDialog;

    public static void showLoadingDialog(Context mContext, int msgId) {
        try {
            if (mContext != null) {
                mProgressDialog = new ProgressDialog(mContext);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setCanceledOnTouchOutside(false);
                mProgressDialog.setMessage(mContext.getResources().getString(msgId));
                mProgressDialog.show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void hideProgressDialog() {
        try {
            if (mProgressDialog != null)
                mProgressDialog.dismiss();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
