package com.codexive.personalorganiser.di.module;

import android.app.Application;
import android.content.Context;


import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.AppDataManager;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.AppDbHelper;
import com.codexive.personalorganiser.data.db.DbHelper;
import com.codexive.personalorganiser.data.prefs.AppPreferencesHelper;
import com.codexive.personalorganiser.data.prefs.PreferencesHelper;
import com.codexive.personalorganiser.di.ApplicationContext;
import com.codexive.personalorganiser.di.DatabaseInfo;
import com.codexive.personalorganiser.di.PreferenceInfo;
import com.codexive.personalorganiser.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }



    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ViewPump provideCalligraphyDefaultConfig() {
        return ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }
}
