package com.lauri.oliolutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lauri.oliolutemon.location.BattleArena;
import com.lauri.oliolutemon.location.Home;

public class BattleArenaActivity extends AppCompatActivity {
    private BattleArena battleArena = LocationStorage.getInstance().getBattleArena();
    private BattleArenaRecyclerViewAdapter rvAdapter;
    private TextView battleOutput;
    private Home home = LocationStorage.getInstance().getHome();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_battle_arena);
        RecyclerView recyclerView = findViewById(R.id.BattleArenaRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new BattleArenaRecyclerViewAdapter(getApplicationContext(), battleArena.getLutemons());
        recyclerView.setAdapter(rvAdapter);
        battleOutput = findViewById(R.id.battleOutputText);
    }

    public void startBattle(View view){
        if(battleArena.getLutemons().size() < 2){
            battleOutput.setText("Not enough lutemons to fight");
            return;
        }
        String battle = battleArena.battle();
        sendLutemonsHome();
        battleOutput.setText(battle);

    }
    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void sendLutemonsHome(){
        for(int key : battleArena.getLutemons().keySet()){
            home.addLutemon(key, battleArena.yoinkLutemon(key));
        }
        rvAdapter.clearLutemonsToDisplay();
        rvAdapter.notifyDataSetChanged();
    }
}