package com.example.quiz2thread;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.lang.ref.WeakReference;

public class TimeTask extends AsyncTask<Void,Integer,Void> {
    private final WeakReference<ProgressBar> pbref;
    private final WeakReference<TextView> text;
    private final Context c;

    int time=0;


    public TimeTask(ProgressBar pb,TextView text,Context contextc){
        this.pbref =new WeakReference<>(pb);
        this.text=new WeakReference<>(text);
        this.c=contextc;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            for(int i=0;i<100;i++){
                Thread.sleep(10);
                publishProgress(i);
                if(i%10==0){
                    time++;
                }
            }
        }catch(Exception e){

        }
        return  null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        pbref.get().setProgress(values[0]);

        int temp=10-time;
        text.get().setText(String.valueOf(temp)+" Second");

    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        new AlertDialog.Builder(c)
                .setTitle("Time Up")
                .setMessage("You Lose")
                .setPositiveButton("Restart",(dialog, i) ->{
                    new TimeTask(pbref.get(), text.get(),c).execute();
                } )
                .create()
                .show();

    }
}
