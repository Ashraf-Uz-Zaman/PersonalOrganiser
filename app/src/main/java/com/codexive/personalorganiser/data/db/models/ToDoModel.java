package com.codexive.personalorganiser.data.db.models;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;


@Entity(nameInDb = "todo_model")
public class ToDoModel {

    @SerializedName("id")
    @Expose
    @Id
    @Property(nameInDb = "id")
    private Long id;

    @ColumnInfo(name = "todo_taskName")
    @SerializedName("todo_taskName")
    @Expose
    @Property(nameInDb = "todo_taskName")
    String todo_taskName;
    @ColumnInfo(name = "todo_location")
    @SerializedName("todo_location")
    @Expose
    @Property(nameInDb = "todo_location")
    String todo_location;
    @ColumnInfo(name = "todo_status")
    @SerializedName("todo_status")
    @Expose
    @Property(nameInDb = "Expose")
    boolean todo_status;

    @Generated(hash = 915503209)
    public ToDoModel(Long id, String todo_taskName, String todo_location,
            boolean todo_status) {
        this.id = id;
        this.todo_taskName = todo_taskName;
        this.todo_location = todo_location;
        this.todo_status = todo_status;
    }

    @Generated(hash = 219259818)
    public ToDoModel() {
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
}
