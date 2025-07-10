package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public void switchToHomeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void switchToTrainingAreaActivity(View view){
        Intent intent = new Intent(this, TrainingAreaActivity.class);
        startActivity(intent);
    }

    public void switchToBattleArenaActivity(View view){
        Intent intent = new Intent(this, BattleArenaActivity.class);
        startActivity(intent);
    }
}