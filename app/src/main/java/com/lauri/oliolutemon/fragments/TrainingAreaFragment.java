package com.lauri.oliolutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lauri.oliolutemon.LutemonStorage;
import com.lauri.oliolutemon.LutemonsHomeListAdapter;
import com.lauri.oliolutemon.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingAreaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingAreaFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_area, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.LutemonTrainingRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new LutemonsHomeListAdapter(getContext(), LutemonStorage.getInstance().getTrainingArea().getLutemons()));

        return view;
    }
}