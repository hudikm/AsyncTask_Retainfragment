package com.example.hudik1.asynctask_retainfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 *
 */
public class ItemFragment extends Fragment {


    //Database simulation -> data localData
    private String[] remoteData = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10", "item 11", "item 12", "item 13", "item 14", "item 15", "item 16", "item 17", "item 18", "item 19", "item 20", "item 21", "item 22"};
    private AddStringAsyncTask addStringAsyncTask;

    public ArrayList<String> getLocalData() {
        return localData;
    }

    private ArrayList<String> localData;

    public ArrayAdapter<String> getArrayAdapter() {
        return myArrayAdapter;
    }
    private ArrayAdapter<String> myArrayAdapter;

    //Factory method
    public static ItemFragment newInstance(Context context) {
        ItemFragment fragment = new ItemFragment();

        //Create new ArrayAdapter
        fragment.myArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO Use this fragment as RetainFragment http://developer.android.com/guide/topics/resources/runtime-changes.html
        /*FIXME Uncomment next lines*/
        // setRetainInstance(true);
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (localData == null) {
            localData = new ArrayList<String>();
            myArrayAdapter.addAll(localData);

            //TODO create AddStringAsyncTask and start AsyncTask with call to "execute" method
            /*FIXME Uncomment next 2 lines */
//            addStringAsyncTask = new AddStringAsyncTask();
//            addStringAsyncTask.execute();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //TODO use AsyncTask for filling myArrayAdapter with data from remoteData
    // Link: http://developer.android.com/reference/android/os/AsyncTask.html
    // Hint:
    // Load data in 'for' cycle. Every cycle iteration slowdown with use of 'SystemClock.sleep(500)' wich will emulate slow loading
    // For adding data to 'arrayAdapter' use : myArrayAdapter.add(values[0])

    class AddStringAsyncTask extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            //Simulate slow download from database
            for (String s : remoteData) {
                publishProgress(s);
                SystemClock.sleep(500);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            myArrayAdapter.add(values[0]);
            myArrayAdapter.notifyDataSetChanged();
        }
    }

}
