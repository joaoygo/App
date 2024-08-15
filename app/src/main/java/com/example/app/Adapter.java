package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.TaskModel;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private List<TaskModel> taskList;

    public Adapter(List<TaskModel> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {
        TaskModel task = taskList.get(position);
        holder.tv_title.setText(task.title);
        holder.tv_description.setText(task.description);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class AdapterViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title;
        TextView tv_description;
        ConstraintLayout card_layout;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            card_layout = itemView.findViewById(R.id.cardView);

            tv_title.setOnClickListener(this);
            tv_description.setOnClickListener(this);
            card_layout.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Você clicou no item" + tv_title.getText(), Toast.LENGTH_LONG).show();
        }
    }
}
