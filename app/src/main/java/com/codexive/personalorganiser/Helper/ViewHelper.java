package com.codexive.personalorganiser.Helper;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
                .setBackgroundResource(R.drawable.style_background_splash)
                .setFullScreen(true)
                .setDuration(5500)
                .show();
    }

    public static void setImage(Context context, ImageView imageView, String url, RequestOptions requestOptions){
        try {
            Glide.with(context).load(url).apply(requestOptions).into(imageView);
        } catch (Exception ex) {
            Log.e(String.valueOf(context), "setImage: ",ex );
        }
    }
}
