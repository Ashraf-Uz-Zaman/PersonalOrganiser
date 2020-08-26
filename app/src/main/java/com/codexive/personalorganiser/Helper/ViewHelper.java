package com.codexive.personalorganiser.Helper;

import android.app.Activity;
import android.content.Context;

import com.codexive.personalorganiser.R;
import com.rbddevs.splashy.Splashy;

public class ViewHelper {
    public static void SplashScreen(Activity activity){
        new Splashy(activity)         // For JAVA : new Splashy(this)
                .setLogo(R.drawable.ic_launcher_foreground)
                .setTitle(R.string.splash_title)
                .setTitleColor("#FFFFFF")
                .setSubTitle(R.string.splash_sub_title)
                .setAnimation(Splashy.Animation.GLOW_LOGO,1000)
                .setProgressColor(R.color.white)
                .setBackgroundResource(android.R.color.black)
                .setFullScreen(true)
                .setDuration(5000)
                .show();
    }
}
