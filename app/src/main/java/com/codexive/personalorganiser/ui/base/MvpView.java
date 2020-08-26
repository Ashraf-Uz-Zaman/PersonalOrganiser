package com.codexive.personalorganiser.ui.base;

import android.content.Context;

import androidx.annotation.StringRes;

public interface MvpView {

    void showLoading(String label);

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    Context getContext();
}
