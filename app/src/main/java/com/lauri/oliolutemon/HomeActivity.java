package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.monsters.Lutemon;

public class HomeActivity extends AppCompatActivity {
    private EditText lutemonName;
    private RadioGroup lutemonType;
    private HomeRecyclerViewAdapter rvAdapter;
    private final Home home = LutemonLocationStorage.getInstance().getHome();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        lutemonName = findViewById(R.id.LutemonNameEdit);
        lutemonType = findViewById(R.id.RadioGroup);
        RecyclerView recyclerView = findViewById(R.id.HomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new HomeRecyclerViewAdapter(getApplicationContext(), home.getLutemons());
        recyclerView.setAdapter(rvAdapter);
    }
    public void createLutemon(View view){
        String name = lutemonName.getText().toString();
        LutemonType type;

        int checkedRadioButtonId = lutemonType.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.LutemonBlackBtn){
            type = LutemonType.BLACK;
        } else if (checkedRadioButtonId == R.id.LutemonGreenBtn) {
            type = LutemonType.GREEN;
        } else if (checkedRadioButtonId == R.id.LutemonOrangeBtn) {
            type = LutemonType.ORANGE;
        } else if (checkedRadioButtonId == R.id.LutemonPinkBtn) {
            type = LutemonType.PINK;
        } else if (checkedRadioButtonId == R.id.LutemonWhiteBtn) {
            type = LutemonType.WHITE;
        } else{
            Toast.makeText(this,"Choose type", Toast.LENGTH_SHORT).show();
            return;
        }
        Lutemon createdLutemon = LutemonLocationStorage.getInstance().getHome().createLutemon(type, name);
        rvAdapter.addToLutemonsToDisplay(createdLutemon);
        rvAdapter.notifyItemInserted(LutemonLocationStorage.getInstance().getHome().getLutemons().size() - 1);
    }

    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}