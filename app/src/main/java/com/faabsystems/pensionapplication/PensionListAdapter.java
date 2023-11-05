package com.faabsystems.pensionapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PensionListAdapter extends RecyclerView.Adapter<PensionListAdapter.PensionListRecyclerViewHolder>{

    public ArrayList<Pensioneer> data;
    public PensionListAdapter(ArrayList<Pensioneer> pensioneerList){
        this.data = pensioneerList;
    }
    @NonNull
    @Override
    public PensionListAdapter.PensionListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pensioneer_list_item, parent, false);
        PensionListRecyclerViewHolder viewHolder = new PensionListRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PensionListAdapter.PensionListRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PensionListRecyclerViewHolder extends RecyclerView.ViewHolder {

        public PensionListRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
