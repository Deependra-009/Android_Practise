package com.example.fragment_quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_quiz.databinding.FragmentQ1Binding;


public class q1 extends Fragment {


    private FragmentQ1Binding bind;
    private q1Args args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind = FragmentQ1Binding.bind(view);
        args = q1Args.fromBundle(getArguments());
        bind.pnq1.setText(args.getName());
        bind.q1score.setText("0");
        bind.btnq1.setOnClickListener(v->{
            int sel = bind.radiogroup.getCheckedRadioButtonId();
            if (sel == R.id.r2) {
                q1Directions.ActionQ1ToQ2 dir = q1Directions.actionQ1ToQ2();
                dir.setName(args.getName());
                dir.setScore(1);
                NavHostFragment.findNavController(this).navigate(dir);
            } else {
                q1Directions.ActionQ1ToGameover dir1 = q1Directions.actionQ1ToGameover();
                dir1.setName(args.getName());
                dir1.setScore(0);
                NavHostFragment.findNavController(this).navigate(dir1);
            }
        });
    }
}