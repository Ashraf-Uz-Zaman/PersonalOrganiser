package com.codexive.personalorganiser.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codexive.personalorganiser.Helper.ViewHelper;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.ui.base.BaseActivity;
import com.codexive.personalorganiser.ui.fragment.event.EventFragment;
import com.codexive.personalorganiser.ui.fragment.friend.FriendsFragment;
import com.codexive.personalorganiser.ui.fragment.gallery.GalleryFragment;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    final Fragment eventFragment = EventFragment.newInstance();
    final Fragment todoFragment = ToDoFragment.newInstance();
    final Fragment friendFragment = FriendsFragment.newInstance();
    final Fragment galleryFragment = GalleryFragment.newInstance();

    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active = eventFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        ViewHelper.SplashScreen(this);
        getSupportFragmentManager().beginTransaction().add(R.id.container, galleryFragment, "Gallery").hide(galleryFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container, friendFragment, "Friend").hide(friendFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container, todoFragment, "ToDo").hide(todoFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container, eventFragment, "Event").commit();
        setUp();
    }

    @Override
    protected void setUp() {
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_event:
                fragmentManager.beginTransaction().hide(active).show(eventFragment).commit();
                active = eventFragment;
                return true;
            case R.id.navigation_todo:
                fragmentManager.beginTransaction().hide(active).show(todoFragment).commit();
                active = todoFragment;
                return true;
            case R.id.navigation_friends:
                fragmentManager.beginTransaction().hide(active).show(friendFragment).commit();
                active = friendFragment;
                return true;
            case R.id.navigation_gallery:
                fragmentManager.beginTransaction().hide(active).show(galleryFragment).commit();
                active = galleryFragment;
                return true;

        }
        return false;
    }
}