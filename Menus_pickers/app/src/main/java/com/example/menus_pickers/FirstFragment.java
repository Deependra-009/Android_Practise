package com.example.menus_pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

public class FirstFragment extends Fragment {

    private com.example.menus_pickers.databinding.FragmentFirstBinding bind;

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
        bind = com.example.menus_pickers.databinding.FragmentFirstBinding.bind(view);
        bind.butdate.setOnClickListener(v->{
//            DatePickerDialog.newInstance
        });

    }

}
//    final Calendar c=Calendar.getInstance();
//    int year=c.get(Calendar.YEAR);
//    int month=c.get(Calendar.MONTH);
//    int day=c.get(Calendar.DAY_OF_MONTH);