package com.codexive.personalorganiser.data;


import com.codexive.personalorganiser.data.db.DbHelper;
import com.codexive.personalorganiser.data.prefs.PreferencesHelper;

public interface DataManager extends DbHelper,PreferencesHelper {

    void setUserAsLoggedOut();

    void updateUserInfo(
            Long userId,
            LoggedInMode loggedInMode);

    enum LoggedInMode {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);
        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
