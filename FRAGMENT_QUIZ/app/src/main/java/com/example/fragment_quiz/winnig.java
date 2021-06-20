package com.example.fragment_quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment_quiz.databinding.FragmentWinnigBinding;

public class winnig extends Fragment {


    private FragmentWinnigBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_winnig, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentWinnigBinding.bind(view);
        winnigArgs args = com.example.fragment_quiz.winnigArgs.fromBundle(getArguments());
        bind.wplayername.setText(args.getName());
        bind.wscore.setText(Integer.toString(args.getScore()));
        bind.homebtn.setOnClickListener(view6->{
            winnigDirections.ActionWinnigToFirstFragment2 dir = winnigDirections.actionWinnigToFirstFragment2();
            NavHostFragment.findNavController(this).navigate(dir);


        });
    }
}