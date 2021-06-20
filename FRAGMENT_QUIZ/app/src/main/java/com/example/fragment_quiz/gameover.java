package com.example.fragment_quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_quiz.databinding.FragmentGameoverBinding;


public class gameover extends Fragment {

    private  FragmentGameoverBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gameover, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentGameoverBinding.bind(view);
        gameoverArgs args = com.example.fragment_quiz.gameoverArgs.fromBundle(getArguments());
        bind.goplayername.setText(args.getName());
        bind.goscore.setText(Integer.toString(args.getScore()));
        bind.playagain.setOnClickListener(view5->{
            gameoverDirections.ActionGameoverToFirstFragment2 dir = gameoverDirections.actionGameoverToFirstFragment2();
            NavHostFragment.findNavController(this).navigate(dir);


        });
    }
}