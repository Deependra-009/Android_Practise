package com.example.fragment_quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_quiz.databinding.FragmentQ3Binding;

public class q3 extends Fragment {

    private  FragmentQ3Binding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentQ3Binding.bind(view);
        q3Args args3 = com.example.fragment_quiz.q3Args.fromBundle(getArguments());
        bind.pnq3.setText(args3.getName());
        bind.q3score.setText(Integer.toString(args3.getScore()));
        bind.btnq3.setOnClickListener(view3->{
            int sel = bind.radiogroupq3.getCheckedRadioButtonId();
            if(sel==R.id.q3r1)
            {
                q3Directions.ActionQ3ToWinnig dir = q3Directions.actionQ3ToWinnig();
                dir.setName(args3.getName());
                dir.setScore(3);
                NavHostFragment.findNavController(this).navigate(dir);
            }
            else
            {
                q3Directions.ActionQ3ToGameover dir1 = q3Directions.actionQ3ToGameover();
                dir1.setName(args3.getName());
                dir1.setScore(2);
                NavHostFragment.findNavController(this).navigate(dir1);
            }
        });
    }
}