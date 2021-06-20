package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.databinding.FragmentIntroFragementBinding;

public class IntroFragement extends Fragment {

    private FragmentIntroFragementBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_fragement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentIntroFragementBinding.bind(view);
        bind.btncontinue.setOnClickListener(v->{
            NavHostFragment.findNavController(this).navigate(R.id.action_introFragement_to_loginFragment);
        });
    }
}