package com.example.app.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.app.DAO.TaskDAO;
import com.example.app.Model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDAO taskDao();
}
