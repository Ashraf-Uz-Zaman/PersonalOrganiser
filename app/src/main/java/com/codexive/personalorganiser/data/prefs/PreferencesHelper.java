package com.codexive.personalorganiser.data.prefs;


import com.codexive.personalorganiser.data.DataManager;

public interface PreferencesHelper {
    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);
//    id
    String getCurrentUserId();

    void setCurrentUserId(String userId);
//    typeId
    String getCurrentUserTypeId();

    void setCurrentUserTypeId(String userTypeId);
//    name
    String getCurrentUserName();

    void setCurrentUserName(String userName);
//    email
    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);
//    image
    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
//    phone
    String getCurrentUserPhone();

    void setCurrentUserPhone(String phone);
//    DOB
    String getCurrentUserDob();

    void setCurrentUserDob(String dob);
//    gender
    String getCurrentUserGender();

    void setCurrentUserGender(String gender);

//    adress
    String getCurrentUserAdress();

    void setCurrentUserAdress(String adress);
//    city
    String getCurrentUserCity();

    void setCurrentUserCity(String city);
    String getAccessToken();

    void setAccessToken(String accessToken);
}
