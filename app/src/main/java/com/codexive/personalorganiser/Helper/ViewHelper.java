package com.codexive.personalorganiser.Helper;

import android.app.Activity;
import android.content.Context;

import com.codexive.personalorganiser.R;
import com.rbddevs.splashy.Splashy;

public class ViewHelper {
    public static void SplashScreen(Activity activity){
        new Splashy(activity)         // For JAVA : new Splashy(this)
                .setLogo(R.drawable.img_personal_organizer)
                .setTitle(R.string.splash_title)
                .setTitleSize(18)
                .setTitleColor(R.color.white)
                .setSubTitle(R.string.splash_sub_title)
                .setSubTitleSize(13)
                .setAnimation(Splashy.Animation.GLOW_LOGO,1500)
                .setProgressColor(R.color.white)
                .setBackgroundResource(android.R.color.black)
                .setFullScreen(true)
                .setDuration(5500)
                .show();
    }
}
