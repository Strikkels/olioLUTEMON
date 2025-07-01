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

import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.monsters.Black;
import com.lauri.oliolutemon.monsters.Green;
import com.lauri.oliolutemon.monsters.Lutemon;
import com.lauri.oliolutemon.monsters.Orange;
import com.lauri.oliolutemon.monsters.Pink;
import com.lauri.oliolutemon.monsters.White;

public class HomeActivity extends AppCompatActivity {
    private EditText lutemonName;
    private RadioGroup lutemonType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_lutemon);

        Home home = LutemonStorage.getInstance().getHome();
        lutemonName = findViewById(R.id.LutemonNameEdit);
        lutemonType = findViewById(R.id.RadioGroup);

        RecyclerView recyclerView = findViewById(R.id.LutemonTestRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonsHomeListAdapter(getApplicationContext(), LutemonStorage.getInstance().getHome().getLutemons()));
    }
    public void createLutemon(View view){
        String name = lutemonName.getText().toString();
        Lutemon lutemon = null;

        int checkedRadioButtonId = lutemonType.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.LutemonBlackBtn){
            lutemon = new Black(name);
        } else if (checkedRadioButtonId == R.id.LutemonGreenBtn) {
            lutemon = new Green(name);
        } else if (checkedRadioButtonId == R.id.LutemonOrangeBtn) {
            lutemon = new Orange(name);
        } else if (checkedRadioButtonId == R.id.LutemonPinkBtn) {
            lutemon = new Pink(name);
        } else if (checkedRadioButtonId == R.id.LutemonWhiteBtn) {
            lutemon = new White(name);
        } else{
            Toast.makeText(this,"Choose type", Toast.LENGTH_SHORT).show();
            return;
        }
        System.out.println("nimi: " + name + " tyyppi: " + lutemon.getType() + " id: " + lutemon.getId());
        LutemonStorage.getInstance().getHome().createLutemon(lutemon);

    }

    public void cancelCreation(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}