package com.example.quiz2thread;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.quiz2thread.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ProgressBar pb;
    private AsyncTask<Void, Integer, Void> task;
    private @NonNull NavDirections dir,dir1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pb = binding.progress;

        task = new TimeTask(pb,binding.timer,getActivity()).execute();
        binding.btn3.setOnClickListener(v->{
            task.cancel(true);
            dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            NavHostFragment.findNavController(this).navigate(dir);

        });
        binding.btn1.setOnClickListener(v->{wronganswer();});
        binding.btn2.setOnClickListener(v->{wronganswer();});
        binding.btn4.setOnClickListener(v->{wronganswer();});

    }

    private void wronganswer() {
        pb=getActivity().findViewById(R.id.progress);
        pb.setProgress(0);
        task.cancel(true);
        dir1 = FirstFragmentDirections.actionFirstFragmentToFragmentThird();
        NavHostFragment.findNavController(this).navigate(dir1);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}