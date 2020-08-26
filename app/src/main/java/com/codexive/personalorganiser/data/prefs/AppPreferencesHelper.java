package com.codexive.personalorganiser.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.di.ApplicationContext;
import com.codexive.personalorganiser.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper{
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_CURRENT_USER_TYPE_ID = "PREF_KEY_CURRENT_USER_TYPE_ID";
    private static final String PREF_KEY_CURRENT_USER_PHONE = "PREF_KEY_CURRENT_USER_PHONE";
    private static final String PREF_KEY_CURRENT_USER_DOB = "PREF_KEY_CURRENT_USER_DOB";
    private static final String PREF_KEY_CURRENT_USER_GENDER = "PREF_KEY_CURRENT_USER_GENDER";
    private static final String PREF_KEY_CURRENT_USER_CITY = "PREF_KEY_CURRENT_USER_CITY";
    private static final String PREF_KEY_CURRENT_USER_ADDRESS = "PREF_KEY_CURRENT_USER_ADDRESS";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getCurrentUserId() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_ID, null);
    }

    @Override
    public void setCurrentUserId(String userId) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply();
    }

    @Override
    public String getCurrentUserTypeId() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_TYPE_ID, null);
    }

    @Override
    public void setCurrentUserTypeId(String userTypeId) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_TYPE_ID, userTypeId).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply();
    }

    @Override
    public String getCurrentUserPhone() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PHONE, null);
    }

    @Override
    public void setCurrentUserPhone(String phone) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PHONE, phone).apply();
    }

    @Override
    public String getCurrentUserDob() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_DOB, null);
    }

    @Override
    public void setCurrentUserDob(String dob) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_DOB, dob).apply();
    }

    @Override
    public String getCurrentUserGender() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_GENDER, null);
    }

    @Override
    public void setCurrentUserGender(String gender) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_GENDER, gender).apply();
    }

    @Override
    public String getCurrentUserAdress() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_ADDRESS, null);
    }

    @Override
    public void setCurrentUserAdress(String adress) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ADDRESS, adress).apply();
    }

    @Override
    public String getCurrentUserCity() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_CITY, null);
    }

    @Override
    public void setCurrentUserCity(String city) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_CITY, city).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }
}
