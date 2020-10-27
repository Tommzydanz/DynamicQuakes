package com.example.dynamicquakes;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dynamicquakes.model.Feature;
import com.example.dynamicquakes.model.Properties;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuakeRecyclerAdapter extends RecyclerView.Adapter<QuakeRecyclerAdapter.ViewHolder>{

    private Context context;

    public void setFeatures(List<Feature> features) {
        this.features = features;
        notifyDataSetChanged();
    }

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
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormat.format(dateObject);
    }

    @Override
    public void onBindViewHolder(@NonNull QuakeRecyclerAdapter.ViewHolder holder, int position) {
        Feature report = features.get(position);
        holder.mTitle.setText(report.getProperties().getTitle());
        holder.mMagnitude.setText(String.format("M %s", report.getProperties().getMagAsString()));
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(report.getProperties().getTime());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);
        holder.mDate.setText(formattedDate);
        holder.mTime.setText(formattedTime);
        holder.mStatus.setText(report.getProperties().getStatus());
        holder.itemView.setOnClickListener(v -> {
            Intent weViewIntent = new Intent(context.getApplicationContext(), WebViewActivity.class);
            weViewIntent.putExtra("url", report.getProperties().getUrl());
            context.startActivity(weViewIntent);
        });

    }

    @Override
    public int getItemCount() {
            return features.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle, mDate, mTime;
        public TextView mMagnitude, mStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.quake_report_title);
            mDate = itemView.findViewById(R.id.quake_date);
            mTime = itemView.findViewById(R.id.quake_time);
            mMagnitude = itemView.findViewById(R.id.quake_magnitude);
            mStatus = itemView.findViewById(R.id.quake_status);
        }

    }
}
