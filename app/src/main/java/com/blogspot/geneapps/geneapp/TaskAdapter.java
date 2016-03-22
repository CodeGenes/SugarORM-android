package com.blogspot.geneapps.geneapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gene on 3/20/2016.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskVH> {
    
    Context context;
    List<TasksModel> Tasks;

    public TaskAdapter(Context context, List<TasksModel> Tasks) {
        this.context = context;
        this.Tasks = Tasks;

    }


    @Override
    public TaskVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskVH(view);
    }

    @Override
    public void onBindViewHolder(TaskVH holder, int position) {

        holder.title.setText(Tasks.get(position).getTitle());
        holder.Task.setText(Tasks.get(position).getTask());

    }

    @Override
    public int getItemCount() {
        return Tasks.size();
    }

    class TaskVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, Task;

        public TaskVH(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            Task = (TextView) itemView.findViewById(R.id.task);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final TasksModel task = Tasks.get(getAdapterPosition());
            Intent i = new Intent(context, AddActivity.class);
            i.putExtra("editing", true);
            i.putExtra("title", task.getTitle());
            i.putExtra("task", task.getTask());
            i.putExtra("time", task.getTime());

            context.startActivity(i);
        }
    }

}
