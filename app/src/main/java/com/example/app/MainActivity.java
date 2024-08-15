package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.app.DAO.TaskDAO;
import com.example.app.Database.AppDatabase;
import com.example.app.Model.TaskModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TaskModel> taskList;
    private Adapter adapter;
    private FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_user);
        taskList = new ArrayList<>();
        btn = findViewById(R.id.btn_move_add_item);
        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_tasks")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        TaskDAO taskDAO = appDatabase.taskDao();

        taskList = taskDAO.getAllTasks();

        for (TaskModel task : taskList) {
            Log.d("TAG", "Task Title: " + task.title + ", Task Descrição: " + task.description);
        }

        adapter = new Adapter(taskList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });
    }
}