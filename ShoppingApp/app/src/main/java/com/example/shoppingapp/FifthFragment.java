package com.example.shoppingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingapp.databinding.FragmentFifthBinding;


public class FifthFragment extends Fragment {


    private FragmentFifthBinding bind;
    private FifthFragmentArgs args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentFifthBinding.bind(view);
        args = FifthFragmentArgs.fromBundle(getArguments());
        bind.bookaddress.setText(args.getAddress());
        bind.bookamount.setText(String.valueOf(args.getPrice()));
        bind.bookdelievery.setText(args.getDelieveryoption());
        bind.bookitemname.setText(args.getProductname());
        bind.bookname.setText(args.getName());
        bind.bookphone.setText(String.valueOf(args.getPhone()));

        bind.bookhome.setOnClickListener(view1->{
            NavDirections dir = FifthFragmentDirections.actionFifthFragmentToFirstFragment();
            NavHostFragment.findNavController(this).navigate(dir);
        });


    }
}