package com.example.shoppingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shoppingapp.databinding.FragmentThirdfragmentBinding;


public class thirdfragment extends Fragment {


    private thirdfragmentArgs args;
    String option="";
    private thirdfragmentDirections.ActionThirdfragmentToFourthFragment dir;
    private String address="";
    private FragmentThirdfragmentBinding bind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_thirdfragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentThirdfragmentBinding.bind(view);
        args = thirdfragmentArgs.fromBundle(getArguments());
        bind.itemname.setText(args.getProductname());
        bind.name.setText(args.getName());
        bind.phoneno.setText(String.valueOf(args.getPhone()));



        bind.radioGroup.setOnCheckedChangeListener((radioGroup,i)->{
            switch (i){
                case R.id.r1: option=bind.r1.getText().toString();
                                bind.spinner.setVisibility(View.GONE);
                                break;
                case R.id.r2: option=bind.r2.getText().toString();
                                bind.spinner.setVisibility(View.GONE);
                                break;
                case R.id.r3: option=bind.r3.getText().toString();
                                bind.spinner.setVisibility(View.VISIBLE);
                                break;

            }
        });



        bind.next3.setOnClickListener(view1->{
            address = bind.address123.getText().toString();

            if(option.equals("")){
                Toast.makeText(this.getContext(),"Select Delievery Option",Toast.LENGTH_LONG).show();
            }
            else{
                if(address.equals("")){
                    Toast.makeText(this.getContext(),"All Fields are Required",Toast.LENGTH_LONG).show();
                }
                else{
                    dir = thirdfragmentDirections.actionThirdfragmentToFourthFragment();
                    dir.setAddress(address);
                    dir.setAmount(args.getAmount());
                    dir.setDelieveryoption(option);
                    dir.setName(args.getName());
                    dir.setPhone(args.getPhone());
                    dir.setProductname(args.getProductname());

                    NavHostFragment.findNavController(this).navigate(dir);
                }
            }




        });


    }
}