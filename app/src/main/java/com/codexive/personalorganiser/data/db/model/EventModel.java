package com.codexive.personalorganiser.data.db.model;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventModel {
    @ColumnInfo(name = "event_Name")
    @SerializedName("event_Name")
    @Expose
    String event_Name;
    @ColumnInfo(name = "event_Date")
    @SerializedName("event_Date")
    @Expose
    String event_Date;
    @ColumnInfo(name = "event_Time")
    @SerializedName("event_Time")
    @Expose
    String event_Time;
    @ColumnInfo(name = "event_Location")
    @SerializedName("event_Location")
    @Expose
    String event_Location;

    public EventModel(String event_Name, String event_Date, String event_Time, String event_Location) {
        this.event_Name = event_Name;
        this.event_Date = event_Date;
        this.event_Time = event_Time;
        this.event_Location = event_Location;
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
}
