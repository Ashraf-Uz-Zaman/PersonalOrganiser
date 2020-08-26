package com.codexive.personalorganiser.di.component;

import android.app.Application;
import android.content.Context;

import com.codexive.personalorganiser.MvpApp;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.di.ApplicationContext;
import com.codexive.personalorganiser.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
