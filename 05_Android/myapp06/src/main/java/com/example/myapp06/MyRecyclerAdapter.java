package com.example.myapp06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    ArrayList<FriendItem> friendItems;


    public MyRecyclerAdapter(ArrayList<FriendItem> friendItems) {
        this.friendItems = friendItems;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyRecyclerAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        // ViewHolder 가 재활용 될 때 사용되는 메소드
        FriendItem friendItem = friendItems.get(position);

        // holder에 계속 set
        holder.profile.setImageResource(friendItem.getResourceId());
        holder.name.setText(friendItem.getName());
        holder.msg.setText(friendItem.getMsg());
    }

    @Override
    public int getItemCount() {
        return friendItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView name;
        TextView msg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            name = itemView.findViewById(R.id.tvName);
            msg = itemView.findViewById(R.id.tvMsg);
        }
    }
}
