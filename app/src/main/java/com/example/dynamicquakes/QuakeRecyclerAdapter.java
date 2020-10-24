package com.example.dynamicquakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dynamicquakes.model.Feature;
import com.example.dynamicquakes.model.Properties;

import java.util.List;

public class QuakeRecyclerAdapter extends RecyclerView.Adapter<QuakeRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<Feature> features;

    public QuakeRecyclerAdapter(List<Feature> features, Context context) {
        this.features = features;
        this.context = context;
    }




    @NonNull
    @Override
    public QuakeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quake_report_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuakeRecyclerAdapter.ViewHolder holder, int position) {
        Feature report = features.get(position);

        holder.mTitle.setText(report.getProperties().getTitle());
        holder.mMagnitude.setText(report.getProperties().getMag());
        holder.mDate.setText(report.getProperties().getTime());

    }

    @Override
    public int getItemCount() {
            return features.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, mDate;
        public TextView mMagnitude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.quake_report_title);
            mDate = itemView.findViewById(R.id.quake_date);
            mMagnitude = itemView.findViewById(R.id.quake_magnitude);
        }
    }
}
