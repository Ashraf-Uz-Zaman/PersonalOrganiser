package com.codexive.personalorganiser.data.db.models;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;


public class ToDoNotCompleteModel {
    private Long id;
    String todo_taskName;
    String todo_location;
    String todo_date;
    boolean todo_status;

    public ToDoNotCompleteModel(Long id, String todo_taskName, String todo_location, String todo_date,
                                boolean todo_status) {
        this.id = id;
        this.todo_taskName = todo_taskName;
        this.todo_location = todo_location;
        this.todo_date = todo_date;
        this.todo_status = todo_status;
    }

    public ToDoNotCompleteModel() {
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo_taskName() {
        return this.todo_taskName;
    }

    public void setTodo_taskName(String todo_taskName) {
        this.todo_taskName = todo_taskName;
    }

    public String getTodo_location() {
        return this.todo_location;
    }

    public void setTodo_location(String todo_location) {
        this.todo_location = todo_location;
    }

    public boolean getTodo_status() {
        return this.todo_status;
    }

    public void setTodo_status(boolean todo_status) {
        this.todo_status = todo_status;
    }

    public String getTodo_date() {
        return todo_date;
    }

    public void setTodo_date(String todo_date) {
        this.todo_date = todo_date;
    }

}
