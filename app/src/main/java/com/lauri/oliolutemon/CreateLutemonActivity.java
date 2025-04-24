package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.monsters.Lutemon;

public class CreateLutemonActivity extends AppCompatActivity {
    private EditText lutemonName;
    private RadioGroup lutemonType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_lutemon);

        lutemonName = findViewById(R.id.LutemonNameEdit);
        lutemonType = findViewById(R.id.RadioGroup);

        RecyclerView recyclerView = findViewById(R.id.LutemonTestRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonsListAdapter(LutemonStorage.getInstance().getLutemons()));
    }
    public void createLutemon(View view){
        String name = lutemonName.getText().toString();
        String type = null;

        int checkedRadioButtonId = lutemonType.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.LutemonBlackBtn){
            type = "black";
        } else if (checkedRadioButtonId == R.id.LutemonGreenBtn) {
            type = "green";
        } else if (checkedRadioButtonId == R.id.LutemonOrangeBtn) {
            type = "orange";
        } else if (checkedRadioButtonId == R.id.LutemonPinkBtn) {
            type = "pink";
        } else if (checkedRadioButtonId == R.id.LutemonWhiteBtn) {
            type = "white";
        } else{
            Toast.makeText(this,"Choose type", Toast.LENGTH_SHORT).show();
            return;
        }
        System.out.println("nimi: " + name + " tyyppi: " + type);
        Lutemon lutemon = new Lutemon(name);
        LutemonStorage.getInstance().addLutemon(lutemon);

    }

    public void cancelCreation(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}