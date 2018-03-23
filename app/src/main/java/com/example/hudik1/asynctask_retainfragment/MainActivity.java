package com.example.hudik1.asynctask_retainfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);

        //TODO If doesn't exists ItemFrament than, with use of FragmentManager, create new instance of fragment. Show this new fragment in R.id.container view
        // link: http://developer.android.com/guide/components/fragments.html
        // After app. restart(configuration changes) you need to find the instance of fragment by the Tag name that you assigned when the new fragment was added.

        /*FIXME Uncomment next 4 lines */
        //ItemFragment itemFragment = (ItemFragment) getFragmentManager().findFragmentByTag("retainFragment");
        //if (itemFragment == null) {
        //itemFragment = ItemFragment.newInstance(this);
        //getFragmentManager().beginTransaction().add(itemFragment, "retainFragment").commit();
        //}

        /**
         * Set adapter for listView to ArrayAdapter from intemFragment
         */
        /*FIXME Uncomment next 1 lines */
        //listView.setAdapter(itemFragment.getArrayAdapter());
    }
}
