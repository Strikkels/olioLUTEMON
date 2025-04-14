package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
    }
    public void createLutemon(View view){
        String name = lutemonName.getText().toString();
        String type = null;

        int checkedRadioButtonId = lutemonType.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.LutemonBlackBtn){
            type = "black";
        }
        System.out.println("nimi: " + name + " tyyppi: " + type);
        Lutemon lutemon = new Lutemon(name);
        //LutemonStorage.getInstance().addLutemon(lutemon);

    }

    public void cancelCreation(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}