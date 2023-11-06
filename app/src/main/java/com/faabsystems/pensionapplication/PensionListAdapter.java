package com.faabsystems.pensionapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faabsystems.pensionapplication.databinding.PensioneerListItemBinding;

import java.util.ArrayList;

public class PensionListAdapter extends RecyclerView.Adapter<PensionListAdapter.MyViewHolder>{
    private PensioneerListItemBinding itemBinding;
    public ArrayList<Pensioneer> data;
    public PensionListAdapter(ArrayList<Pensioneer> pensioneerList){
        this.data = pensioneerList;
    }
    @NonNull
    @Override
    public PensionListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemBinding = PensioneerListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PensionListAdapter.MyViewHolder holder, int position) {
        Pensioneer pensioneer = data.get(position);
        itemBinding.itemUserId.setText(pensioneer.getId());
        itemBinding.itemFullName.setText(pensioneer.getFullName());
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
    }
}
