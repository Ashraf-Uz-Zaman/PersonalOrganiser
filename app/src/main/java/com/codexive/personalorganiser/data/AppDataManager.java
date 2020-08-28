package com.codexive.personalorganiser.data;

import android.content.Context;

import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.prefs.PreferencesHelper;
import com.codexive.personalorganiser.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }
    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    @Override
    public void updateUserInfo(Long userId, LoggedInMode loggedInMode) {
//        setCurrentUserId(userId);
//        setCurrentUserLoggedInMode(loggedInMode);
    }
    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(String userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserTypeId() {
        return mPreferencesHelper.getCurrentUserTypeId();
    }

    @Override
    public void setCurrentUserTypeId(String userTypeId) {
        mPreferencesHelper.setCurrentUserTypeId(userTypeId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getCurrentUserPhone() {
        return mPreferencesHelper.getCurrentUserPhone();
    }

    @Override
    public void setCurrentUserPhone(String phone) {
        mPreferencesHelper.setCurrentUserPhone(phone);
    }

    @Override
    public String getCurrentUserDob() {
        return mPreferencesHelper.getCurrentUserDob();
    }

    @Override
    public void setCurrentUserDob(String dob) {
        mPreferencesHelper.setCurrentUserDob(dob);
    }

    @Override
    public String getCurrentUserGender() {
        return mPreferencesHelper.getCurrentUserGender();
    }

    @Override
    public void setCurrentUserGender(String gender) {
        mPreferencesHelper.setCurrentUserGender(gender);
    }

    @Override
    public String getCurrentUserAdress() {
        return mPreferencesHelper.getCurrentUserAdress();
    }

    @Override
    public void setCurrentUserAdress(String adress) {
        mPreferencesHelper.setCurrentUserAdress(adress);
    }

    @Override
    public String getCurrentUserCity() {
        return mPreferencesHelper.getCurrentUserCity();
    }

    @Override
    public void setCurrentUserCity(String city) {
        mPreferencesHelper.setCurrentUserCity(city);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

//  TODO: DB
    @Override
    public Observable<List<EventModel>> getAllEvent() {
        return null;
    }
}
