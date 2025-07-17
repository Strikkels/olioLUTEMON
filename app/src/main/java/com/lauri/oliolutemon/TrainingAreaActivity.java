package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.TrainingArea;

public class TrainingAreaActivity extends AppCompatActivity {
    private TrainingAreaRecyclerViewAdapter rvAdapter;
    private final TrainingArea trainingArea = LocationStorage.getInstance().getTrainingArea();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_area);

        RecyclerView recyclerView = findViewById(R.id.TrainingAreaRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new TrainingAreaRecyclerViewAdapter(getApplicationContext(), trainingArea.getLutemons());
        recyclerView.setAdapter(rvAdapter);
    }

    public void trainLutemons(View view){
        trainingArea.trainLutemons();
        rvAdapter.notifyItemRangeChanged(0, trainingArea.getLutemons().size());
    }

    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}