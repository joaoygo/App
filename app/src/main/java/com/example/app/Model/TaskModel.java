package com.example.app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "titulo")
    public String title;
    @ColumnInfo(name = "descricao")
    public String description;

    public TaskModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return "TaskModel{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
