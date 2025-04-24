package com.lauri.oliolutemon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lauri.oliolutemon.CreateLutemonActivity;
import com.lauri.oliolutemon.LutemonStorage;
import com.lauri.oliolutemon.LutemonsListAdapter;
import com.lauri.oliolutemon.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button addLutemonBtn = view.findViewById(R.id.AddLutemonBtn);

        RecyclerView recyclerView = view.findViewById(R.id.LutemonsRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new LutemonsListAdapter(LutemonStorage.getInstance().getLutemons()));

        addLutemonBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), CreateLutemonActivity.class);
            startActivity(intent);
        });

        return view;
    }

}