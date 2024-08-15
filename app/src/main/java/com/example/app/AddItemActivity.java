package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.app.DAO.TaskDAO;
import com.example.app.Database.AppDatabase;
import com.example.app.Model.TaskModel;

public class AddItemActivity extends AppCompatActivity {
    private EditText title;
    private EditText description;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);

        title = findViewById(R.id.input_title);
        description = findViewById(R.id.input_desc);
        btn = findViewById(R.id.button);

        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_tasks")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        TaskDAO taskDao = appDatabase.taskDao();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskModel task = new TaskModel(title.getText().toString(), description.getText().toString());
                taskDao.insertAll(task);

                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
