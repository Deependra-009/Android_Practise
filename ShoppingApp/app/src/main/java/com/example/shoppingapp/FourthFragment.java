package com.example.shoppingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shoppingapp.databinding.FragmentFourthBinding;

public class FourthFragment extends Fragment {

    private FragmentFourthBinding bind;
    private FourthFragmentArgs args;
    private FourthFragmentDirections.ActionFourthFragmentToFifthFragment dir;
    private String cardnumber;
    private String cardname;
    private String cvv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentFourthBinding.bind(view);
        args = FourthFragmentArgs.fromBundle(getArguments());
        bind.amountpay.setText(String.valueOf(args.getAmount()));

        bind.payment.setOnClickListener(view1->{

            cardnumber = bind.cardnumber.getText().toString();
            cardname = bind.cardholder.getText().toString();
            cvv = bind.cvv.getText().toString();



            if(cardname.length()>0 && cardnumber.length()>0 && cvv.length()>0){

                dir = FourthFragmentDirections.actionFourthFragmentToFifthFragment();
                dir.setAddress(args.getAddress());
                dir.setDelieveryoption(args.getDelieveryoption());
                dir.setName(args.getName());
                dir.setPhone(args.getPhone());
                dir.setPrice(args.getAmount());
                dir.setProductname(args.getProductname());
                NavHostFragment.findNavController(this).navigate(dir);
            }
            else{
                Toast.makeText(this.getContext(),"All Fields are Required",Toast.LENGTH_LONG).show();
            }



        });
    }
}