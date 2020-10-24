package com.example.dynamicquakes;



import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dynamicquakes.model.Feature;
import com.example.dynamicquakes.model.Properties;
import com.example.dynamicquakes.model.QuakeModel;
import com.example.dynamicquakes.services.QuakeApiService;
import com.example.dynamicquakes.services.QuakeInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView textView;
    private List<Feature> featureList;
    private QuakeRecyclerAdapter quakeRecyclerAdapter;
    private Properties properties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            progressBar = findViewById(R.id.progressBar);
            textView = findViewById(R.id.loading_tv);

            final Context context = this;

            featureList = new ArrayList<>();


            quakeRecyclerAdapter = new QuakeRecyclerAdapter(featureList, this);

            recyclerView = findViewById(R.id.quake_report_list);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(quakeRecyclerAdapter);



            Call<QuakeModel> quakeModelCall = QuakeApiService.getInstance().getApi().getQuakeFeatures();


            quakeModelCall.enqueue(new Callback<QuakeModel>() {
                @Override
                public void onResponse(Call<QuakeModel> call, Response<QuakeModel> response) {
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);

                    Feature feature = new Feature(properties);

                    QuakeModel quakeModel = response.body();
                    assert quakeModel != null;
                    quakeModel.getQuakeFeatures().add(feature);
                    quakeRecyclerAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<QuakeModel> call, Throwable t) {
                    Toast.makeText(context, "Unable to connect to server", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                }
            });
    }

}