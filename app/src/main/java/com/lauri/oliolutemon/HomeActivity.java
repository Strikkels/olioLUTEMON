package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.Home;
import com.lauri.oliolutemon.location.LutemonLocation;

public class HomeActivity extends AppCompatActivity {
    private EditText lutemonName;
    private RadioGroup lutemonType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Home home = LutemonLocationStorage.getInstance().getHome();
        lutemonName = findViewById(R.id.LutemonNameEdit);
        lutemonType = findViewById(R.id.RadioGroup);

        RecyclerView recyclerView = findViewById(R.id.lutemonHomeRecyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new LutemonsHomeListAdapter(getApplicationContext(), LutemonStorage.getInstance().getHome().getLutemons()));
    }
    public void createLutemon(View view){
        String name = lutemonName.getText().toString();
        LutemonLocation.LutemonType type = null;

        int checkedRadioButtonId = lutemonType.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.LutemonBlackBtn){
            type = LutemonLocation.LutemonType.BLACK;
        } else if (checkedRadioButtonId == R.id.LutemonGreenBtn) {
            type = LutemonLocation.LutemonType.GREEN;
        } else if (checkedRadioButtonId == R.id.LutemonOrangeBtn) {
            type = LutemonLocation.LutemonType.ORANGE;
        } else if (checkedRadioButtonId == R.id.LutemonPinkBtn) {
            type = LutemonLocation.LutemonType.PINK;
        } else if (checkedRadioButtonId == R.id.LutemonWhiteBtn) {
            type = LutemonLocation.LutemonType.WHITE;
        } else{
            Toast.makeText(this,"Choose type", Toast.LENGTH_SHORT).show();
            return;
        }
        LutemonLocationStorage.getInstance().getHome().createLutemon(type, name);

    }

    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}