package com.example.shoppingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoppingapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private SecondFragmentDirections.ActionSecondFragmentToThirdfragment dir;
    private SecondFragmentArgs args;
    private  FragmentSecondBinding bind;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind = FragmentSecondBinding.bind(view);

        args = SecondFragmentArgs.fromBundle(getArguments());

        bind.next2.setOnClickListener(view1->{

            dir = SecondFragmentDirections.actionSecondFragmentToThirdfragment();
            String productname=bind.productname1.getText().toString();
            String temp=bind.amount1.getText().toString();
            String amount1=temp.substring(1);
            String amount=amount1.replaceAll(",","");

            dir.setAmount(Integer.parseInt(amount));
            dir.setName(args.getName());
            dir.setPhone(args.getPhone());
            dir.setProductname(productname);

            NavHostFragment.findNavController(this).navigate(dir);






        });



    }
}