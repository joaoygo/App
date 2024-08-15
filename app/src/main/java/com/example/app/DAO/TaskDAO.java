package com.example.app.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.Model.TaskModel;

import java.util.List;

@Dao
public interface TaskDAO {

        @Insert
        void insertAll(TaskModel... tasks);

        @Delete
        void delete(TaskModel task);

        @Query("SELECT * FROM task")
        List<TaskModel> getAllTasks();
}
