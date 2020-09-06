package com.codexive.personalorganiser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.db.models.EventModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    public interface EventClick {
        void OnDelete(EventModel eventModel);
    }

    EventClick eventClick;

    private Context context;
    private List<EventModel> list;

    public EventAdapter(Context context, List<EventModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventName.setText(list.get(position).getEvent_Name());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());

        if (currentDateandTime.equals(list.get(position).getEvent_Date())) {
            holder.tvDate.setText("Today (" + list.get(position).getEvent_Time() + ")");
        } else {
            holder.tvDate.setText(list.get(position).getEvent_Date() + " (" + list.get(position).getEvent_Time() + ")");
        }

        holder.eventLocation.setText(list.get(position).getEvent_Location());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<EventModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setListener(EventClick eventClick) {
        this.eventClick = eventClick;
    }

    public void clearData() {
        list.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_name)
        TextView eventName;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.event_location)
        TextView eventLocation;
        @BindView(R.id.img_delete)
        ImageView imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eventClick.OnDelete(list.get(getAdapterPosition()));
                }
            });
        }
    }
}
