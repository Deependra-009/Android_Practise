package com.example.drawerlayout;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.drawerlayout.databinding.FragmentSportBinding;

import java.util.ArrayList;
import java.util.List;

public class SportFragment extends Fragment {
    private List<sport> mSportsData;


    private  FragmentSportBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false);
    }


    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentSportBinding.bind(view);
        bind.floatingActionButton.setOnClickListener(v->{
            Toast.makeText(getContext(), "vgfsd", Toast.LENGTH_SHORT).show();
        });



        mSportsData = new ArrayList<>();
        CharSequence[] titleArray = getActivity().getResources().getTextArray(R.array.sports_titles);
        CharSequence[] infoArray = getActivity().getResources().getTextArray(R.array.sports_info);
        TypedArray imgArray = getActivity().getResources().obtainTypedArray(R.array.sports_images); //  A TypedArray allows you to store an array of other XML resources. Using a TypedArray

        for (int i = 0; i < titleArray.length; i++) {
            mSportsData.add(new sport(titleArray[i], infoArray[i], imgArray.getResourceId(i, 0)));
        }
        bind.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        sportadapter adapter1 = new sportadapter(getActivity(), mSportsData,this);
        bind.recyclerview.setAdapter(adapter1);
        imgArray.recycle(); // remove images from memory
    }
}