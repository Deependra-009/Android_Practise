package com.example.recyclerviewfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewfragment.databinding.FragmentFirstBinding;

import java.util.LinkedList;

public class FirstFragment extends Fragment {
    private final LinkedList<String> mwordlist=new LinkedList<>();
    private  FragmentFirstBinding bind;


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
        for(int i=0;i<20;i++){
            mwordlist.add("word"+i);
        }
        // UI CODE
        bind = FragmentFirstBinding.bind(view);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        WordAdapter adapter=new WordAdapter(getContext(),mwordlist);
        bind.recyclerView.setAdapter(adapter);
        bind.fab.setOnClickListener(v->{
            int size=mwordlist.size();
            mwordlist.addLast("word"+size);
            adapter.notifyItemInserted(size);
            bind.recyclerView.smoothScrollToPosition(size);
        });

    }

    public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{
        private LinkedList<String> mwordlist;
        private LayoutInflater inflater;
        WordAdapter(Context ctx, LinkedList<String> wordlist){
            this.mwordlist=wordlist;
            inflater=LayoutInflater.from(ctx);
        }
        @NonNull
        @Override
        public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v=inflater.inflate(R.layout.cardlist,parent,false);
            return new WordViewHolder(v,this);

        }

        @Override
        public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
            String word=mwordlist.get(position);
            holder.wordText.setText(word);

        }

        @Override
        public int getItemCount() {
            return mwordlist.size();
        }

        public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            WordAdapter adapter;
            TextView wordText;
            public WordViewHolder(@NonNull View itemView, WordAdapter adapter) {
                super(itemView);
                this.adapter=adapter;
                wordText=itemView.findViewById(R.id.listcard);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int currpos=getLayoutPosition();
                String word=mwordlist.get(currpos);
                mwordlist.set(currpos,word+"clicked");
                adapter.notifyDataSetChanged();
            }
        }
    }
}