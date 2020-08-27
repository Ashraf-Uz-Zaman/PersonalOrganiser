package com.codexive.personalorganiser.data.db.model;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ToDoModel {
    @ColumnInfo(name = "todo_taskName")
    @SerializedName("todo_taskName")
    @Expose
    String todo_taskName;
    @ColumnInfo(name = "todo_location")
    @SerializedName("todo_location")
    @Expose
    String todo_location;
    @ColumnInfo(name = "todo_status")
    @SerializedName("todo_status")
    @Expose
    boolean todo_status;

    public ToDoModel(String todo_taskName, String todo_location, boolean todo_status) {
        this.todo_taskName = todo_taskName;
        this.todo_location = todo_location;
        this.todo_status = todo_status;
    }

    public String getTaskName() {
        return todo_taskName;
    }

    public void setTaskName(String todo_taskName) {
        this.todo_taskName = todo_taskName;
    }

    public String getLocation() {
        return todo_location;
    }

    public void setLocation(String todo_location) {
        this.todo_location = todo_location;
    }

    public boolean isStatus() {
        return todo_status;
    }

    public void setStatus(boolean todo_status) {
        this.todo_status = todo_status;
    }
}
