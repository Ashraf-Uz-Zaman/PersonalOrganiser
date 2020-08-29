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
import com.codexive.personalorganiser.custom.CustomImageView;
import com.codexive.personalorganiser.data.db.models.FriendModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private Context context;
    private List<FriendModel> list;

    public FriendsAdapter(Context context, List<FriendModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.itme_frineds_linear, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(getName(position));
        holder.tvGender.setText(getGender(position));
        holder.tvLocation.setText(getLocation(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<FriendModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    private String getName(int pos) {
        return list.get(pos).getFirstName() + " "+list.get(pos).getLastName();
    }
    private String getGender(int pos) {
        return list.get(pos).getGender();
    }
    private String getLocation(int pos) {
        return list.get(pos).getAddress();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_agreement)
        ImageView ivAgreement;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_gender)
        TextView tvGender;
        @BindView(R.id.tv_location)
        TextView tvLocation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
