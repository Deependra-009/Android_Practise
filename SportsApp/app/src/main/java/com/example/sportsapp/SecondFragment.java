package com.example.sportsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sportsapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private com.example.sportsapp.SecondFragmentArgs args;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        args = SecondFragmentArgs.fromBundle(getArguments());
        binding.titl1.setText(args.getTitle());
        binding.summary1.setText(args.getSummary());
        binding.imageView.setImageResource(args.getImage());



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}