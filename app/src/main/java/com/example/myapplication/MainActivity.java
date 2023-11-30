package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// MainActivity.java
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> tasks;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Load tasks from SharedPreferences
        tasks = loadTasks();

        taskAdapter = new TaskAdapter(this, tasks);
        listView.setAdapter(taskAdapter);

        // Handle item clicks to change task status
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = tasks.get(position);
                task.setDone(!task.isDone());
                saveTasks();
                taskAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addTask(View view) {
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText descriptionEditText = findViewById(R.id.descriptionEditText);

        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        Date dueDate = new Date();  // You can implement a DatePicker for a more user-friendly due date selection

        Task newTask = new Task(titleEditText, description,  false);
        tasks.add(newTask);

        saveTasks();
        taskAdapter.notifyDataSetChanged();

        titleEditText.setText("");
        descriptionEditText.setText("");
    }

    private void saveTasks() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(tasks);

        editor.putString("tasks", json);
        editor.apply();
    }

    private List<Task> loadTasks() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String json = sharedPreferences.getString("tasks", "");

        Gson gson = new Gson();
        Type type = new TypeToken<List<Task>>() {}.getType();

        return gson.fromJson(json, type);
    }
}
