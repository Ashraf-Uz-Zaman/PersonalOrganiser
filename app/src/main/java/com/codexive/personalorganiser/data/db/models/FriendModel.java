package com.codexive.personalorganiser.data.db.models;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "friend_model")
public class FriendModel {

    @SerializedName("id")
    @Expose
    @Id
    @Property(nameInDb = "id")
    private Long id;

    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    @Expose
    @Property(nameInDb = "firstName")
    String firstName;
    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    @Expose
    @Property(nameInDb = "lastName")
    String lastName;
    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    @Expose
    @Property(nameInDb = "gender")
    String gender;
    @ColumnInfo(name = "age")
    @SerializedName("age")
    @Expose
    @Property(nameInDb = "age")
    String age;
    @ColumnInfo(name = "address")
    @SerializedName("address")
    @Expose
    @Property(nameInDb = "address")
    String address;

    @Generated(hash = 547249318)
    public FriendModel(Long id, String firstName, String lastName, String gender, String age,
            String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    @Generated(hash = 1559500800)
    public FriendModel() {
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
