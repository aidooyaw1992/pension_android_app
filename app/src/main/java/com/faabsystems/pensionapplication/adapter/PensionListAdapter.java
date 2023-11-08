package com.faabsystems.pensionapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;
import com.faabsystems.pensionapplication.databinding.PensioneerListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class PensionListAdapter extends RecyclerView.Adapter<PensionListAdapter.MyViewHolder> {
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(UsersResponse item);
    }

    private PensioneerListItemBinding itemBinding;
    public List<UsersResponse> data;

    public PensionListAdapter(List<UsersResponse> pensioneerList, OnItemClickListener listener) {
        this.data = pensioneerList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PensionListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemBinding = PensioneerListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PensionListAdapter.MyViewHolder holder, int position) {
        holder.bind(data.get(position), listener);

//        UsersResponse pensioneer = data.get(position);
//        itemBinding.itemUserId.setText(pensioneer.getId());
//        itemBinding.itemFullName.setText(pensioneer.getTitle());
//        holder.itemView.setOnClickListener(v -> {
//
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        PensioneerListItemBinding itemBinding;

        public MyViewHolder(@NonNull PensioneerListItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        public void bind(final UsersResponse item, final OnItemClickListener listener) {
//            Picasso.with(itemView.getContext()).load(item.imageUrl).into(image);
            itemBinding.itemUserId.setText(item.getUserId());
            itemBinding.itemFullName.setText(item.getTitle());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
