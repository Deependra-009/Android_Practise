package com.example.fragment_quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_quiz.databinding.FragmentQ1Binding;
import com.example.fragment_quiz.databinding.FragmentQ2Binding;

public class q2 extends Fragment {

    private FragmentQ2Binding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentQ2Binding.bind(view);
        q2Args args2 = com.example.fragment_quiz.q2Args.fromBundle(getArguments());
        bind.pnq2.setText(args2.getName());
        bind.q2score.setText(Integer.toString(args2.getScore()));
        bind.btnq2.setOnClickListener(view2->{
            int sel = bind.radiogroupq2.getCheckedRadioButtonId();
            if(sel==R.id.q2r4)
            {
                q2Directions.ActionQ2ToQ3 dir = q2Directions.actionQ2ToQ3();
                dir.setName(args2.getName());
                dir.setScore(2);
                NavHostFragment.findNavController(this).navigate(dir);
            }
            else
            {
                q2Directions.ActionQ2ToGameover dir1 = q2Directions.actionQ2ToGameover();
                dir1.setName(args2.getName());
                dir1.setScore(1);
                NavHostFragment.findNavController(this).navigate(dir1);
            }

        });
    }
}