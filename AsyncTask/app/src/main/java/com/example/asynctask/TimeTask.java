package com.example.asynctask;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class TimeTask extends AsyncTask<Void,Integer,Void> {

    private final WeakReference<ProgressBar> pbref;
    public Activity context;
    public TimeTask(ProgressBar pb,Activity act){
        this.context=act;
        pbref = new WeakReference<>(pb);

    }

    @Override
    protected Void doInBackground(Void... voids) {

        try{
            for(int i=0;i<100;i++){
                Thread.sleep(100);
                publishProgress(i);
            }
        }catch (Exception e){

        }

        return null;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        pbref.get().setProgress(values[0]);
        TextView tv=context.findViewById(R.id.perc);
        tv.setText(Integer.toString(values[0])+"%");
    }

    @Override
    protected void onPostExecute(Void unused) {
        new AlertDialog.Builder(context)
                .setTitle("Time up")
                .setMessage("You Lose")
                .setPositiveButton("Restart",(dialog,i) ->{
                    Toast.makeText(context,"hello world",Toast.LENGTH_SHORT).show();
                } )
                .setNegativeButton("cancel",(dialog, i) ->{
                    Toast.makeText(context,"Cancel",Toast.LENGTH_SHORT).show();
                } )
                .create()
                .show();
    }
}
