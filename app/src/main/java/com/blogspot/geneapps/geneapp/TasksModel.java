package com.blogspot.geneapps.geneapp;

import com.orm.SugarRecord;

/**
 * Created by Gene on 3/20/2016.
 */
public class TasksModel extends SugarRecord {

    String title, task;
    long time;

    public TasksModel() {}// Sugar recommends you retain Default constructor!

    public TasksModel(String title, String task, long time) {
        this.title = title;
        this.task = task;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
