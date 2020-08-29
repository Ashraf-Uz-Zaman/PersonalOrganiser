package com.codexive.personalorganiser.di.component;


import com.codexive.personalorganiser.di.PerActivity;
import com.codexive.personalorganiser.di.module.ActivityModule;
import com.codexive.personalorganiser.ui.activity.friend.FriendActivity;
import com.codexive.personalorganiser.ui.activity.main.MainActivity;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsFragment;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //    activity
    void inject(MainActivity activity);
    void inject(FriendActivity activity);

    //    fragment
    void inject(GalleryFragment fragment);
    void inject(FriendsFragment fragment);

}
