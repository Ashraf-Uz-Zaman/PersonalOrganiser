package com.codexive.personalorganiser.data.db.model;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FriendModel {
    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    @Expose
    String firstName;
    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    @Expose
    String lastName;
    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    @Expose
    String gender;
    @ColumnInfo(name = "age")
    @SerializedName("age")
    @Expose
    String age;
    @ColumnInfo(name = "address")
    @SerializedName("address")
    @Expose
    String address;

    public FriendModel(String firstName, String lastName, String gender, String age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
