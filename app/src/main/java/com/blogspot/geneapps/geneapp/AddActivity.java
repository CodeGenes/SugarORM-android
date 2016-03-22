package com.blogspot.geneapps.geneapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    FloatingActionButton fab;
    EditText eTitle, eTask;
    String title, task;
    long time;
    boolean editingTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        eTitle = (EditText) findViewById(R.id.title);
        eTask = (EditText) findViewById(R.id.task);

        fab = (FloatingActionButton) findViewById(R.id.addTask);

        editingTask = getIntent().getBooleanExtra("editing", false);
        if (editingTask) {
            title = getIntent().getStringExtra("title");
            task = getIntent().getStringExtra("task");
            time = getIntent().getLongExtra("time", 0);

            eTitle.setText(title);
            eTask.setText(task);
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Add note to database
                String newTitle = eTitle.getText().toString();
                String newTask = eTask.getText().toString();
                long newTime = System.currentTimeMillis();

                /**
                 * TODO: Check if task exists before saving
                 */
                if (!editingTask) {
                    TasksModel task = new TasksModel(newTitle, newTask, newTime);
                    task.save();
                } else {
                    List<TasksModel> tasks = TasksModel.find(TasksModel.class, "title = ?", title);
                    if (tasks.size() > 0) {

                        TasksModel note = tasks.get(0);
                        note.title = newTitle;
                        note.task = newTask;
                        note.time = newTime;

                        note.save();

                    }
                }
                finish();
            }
        });
    }
}
