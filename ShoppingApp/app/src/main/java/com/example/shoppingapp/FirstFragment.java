package com.example.shoppingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoppingapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding bind;
    private FirstFragmentDirections.ActionFirstFragmentToSecondFragment dir;

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

        bind = FragmentFirstBinding.bind(view);
        bind.next1.setOnClickListener(view1->{
            dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            String username=bind.username.getText().toString();
            String phonenumber=bind.userphoneno.getText().toString();
            if(username.length()>0  && phonenumber.length()>0){
                if(phonenumber.length()==10){
                    dir.setName(username);
                    dir.setPhone(Integer.parseInt(phonenumber));
                    NavHostFragment.findNavController(this).navigate(dir);

                }
                else{
                    Toast.makeText(this.getContext(),"Wrong Mobile Number!!!",Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this.getContext(),"All Field are Required",Toast.LENGTH_LONG).show();
            }


        });





    }
}