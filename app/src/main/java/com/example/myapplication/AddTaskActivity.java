package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;


public class AddTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void addTask(View view) {
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText descriptionEditText = findViewById(R.id.descriptionEditText);

        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        Date dueDate = new Date();  // You can implement a DatePicker for a more user-friendly due date selection

        Task newTask = new Task(title, descriptionEditText, false);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("newTask", newTask);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
