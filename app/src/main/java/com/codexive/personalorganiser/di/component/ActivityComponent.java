package com.codexive.personalorganiser.di.component;


import com.codexive.personalorganiser.di.PerActivity;
import com.codexive.personalorganiser.di.module.ActivityModule;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //    activity
//    void inject(LoginActivity activity);

    //    fragment
    void inject(GalleryFragment fragment);

}
