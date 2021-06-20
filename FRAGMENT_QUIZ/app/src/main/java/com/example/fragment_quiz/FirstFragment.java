package com.example.fragment_quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fragment_quiz.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding bind;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind=FragmentFirstBinding.bind(view);
        bind.btnnext.setOnClickListener(view1->{
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            String playername = bind.editname.getText().toString();
            if(playername.length()>0)
            {
                dir.setName(playername);
            }
            NavHostFragment.findNavController(this).navigate(dir);
        });


    }
}