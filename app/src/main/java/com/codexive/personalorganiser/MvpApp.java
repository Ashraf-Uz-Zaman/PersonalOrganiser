package com.codexive.personalorganiser;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.BuildConfig;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.di.component.ApplicationComponent;
import com.codexive.personalorganiser.di.component.DaggerApplicationComponent;
import com.codexive.personalorganiser.di.module.ApplicationModule;

import javax.inject.Inject;

import io.github.inflationx.viewpump.ViewPump;


//import com.codexive.personalorganiser.di.component.DaggerApplicationComponent;

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;
    @Inject
    ViewPump mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        //AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        ViewPump.init(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
