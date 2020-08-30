package com.codexive.personalorganiser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.db.models.ToDoCompleteModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.activity.friend.FriendActivity;
import com.codexive.personalorganiser.ui.activity.todo.ToDoActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToDoCompleteAdapter extends RecyclerView.Adapter<ToDoCompleteAdapter.ViewHolder> {


    private Context context;
    private List<ToDoCompleteModel> list;

    public ToDoCompleteAdapter(Context context, List<ToDoCompleteModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTaskName.setText(list.get(position).getTaskName());
        holder.tvTaskLocation.setText(list.get(position).getTodo_location());
        if (list.get(position).isStatus()) {
            holder.status.setBackground(context.getDrawable(R.drawable.tag_label_green));
            holder.status.setText("Completed");
        } else {
            holder.status.setBackground(context.getDrawable(R.drawable.tag_label_red));
            holder.status.setText("Not completed");
        }
        holder.textViewDayMonth.setText(list.get(position).getTodo_date().substring(0, 6));

        holder.textViewYear.setText(list.get(position).getTodo_date().substring(8));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(ToDoActivity.getStartIntent(context)
                        .putExtra("taskname",list.get(position).getTaskName()).putExtra("location",list.get(position).getLocation())
                        .putExtra("id",list.get(position).getId()).putExtra("status",list.get(position).getTodo_status()).putExtra("date",list.get(position).getTodo_date())
                       );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<ToDoCompleteModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void clearData() {
        list.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.textView_year)
        TextView textViewYear;
        @BindView(R.id.textView_day_month)
        TextView textViewDayMonth;
        @BindView(R.id.linearLayout_date)
        LinearLayout linearLayoutDate;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.tv_task_name)
        TextView tvTaskName;
        @BindView(R.id.tv_task_location)
        TextView tvTaskLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
