package com.codexive.personalorganiser.data.db.models;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "event_model")
public class EventModel {

    @SerializedName("id")
    @Expose
    @Id
    @Property(nameInDb = "id")
    private Long id;

    @ColumnInfo(name = "event_Name")
    @SerializedName("event_Name")
    @Expose
    @Property(nameInDb = "event_Name")
    String event_Name;
    @ColumnInfo(name = "event_Date")
    @SerializedName("event_Date")
    @Expose
    @Property(nameInDb = "event_Date")
    String event_Date;
    @ColumnInfo(name = "event_Time")
    @SerializedName("event_Time")
    @Expose
    @Property(nameInDb = "event_Time")
    String event_Time;
    @ColumnInfo(name = "event_Location")
    @SerializedName("event_Location")
    @Expose
    @Property(nameInDb = "event_Location")
    String event_Location;

    @Generated(hash = 71170712)
    public EventModel(Long id, String event_Name, String event_Date, String event_Time,
            String event_Location) {
        this.id = id;
        this.event_Name = event_Name;
        this.event_Date = event_Date;
        this.event_Time = event_Time;
        this.event_Location = event_Location;
    }

    @Generated(hash = 1307476520)
    public EventModel() {
    }

    public String getEvent_Name() {
        return event_Name;
    }

    public void setEvent_Name(String event_Name) {
        this.event_Name = event_Name;
    }

    public String getEvent_Date() {
        return event_Date;
    }

    public void setEvent_Date(String event_Date) {
        this.event_Date = event_Date;
    }

    public String getEvent_Time() {
        return event_Time;
    }

    public void setEvent_Time(String event_Time) {
        this.event_Time = event_Time;
    }

    public String getEvent_Location() {
        return event_Location;
    }

    public void setEvent_Location(String event_Location) {
        this.event_Location = event_Location;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
