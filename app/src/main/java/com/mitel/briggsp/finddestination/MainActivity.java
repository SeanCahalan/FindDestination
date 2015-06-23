package com.mitel.briggsp.finddestination;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.powersave.BackgroundPowerSaver;
import org.altbeacon.beacon.startup.BootstrapNotifier;
import org.altbeacon.beacon.startup.RegionBootstrap;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener, BootstrapNotifier {
    protected static final String TAG = "RogerRoger";
    private RegionBootstrap regionBootstrap;
    private BackgroundPowerSaver backgroundPowerSaver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Region region = new Region("Merp", null, null, null);
        regionBootstrap = new RegionBootstrap(this, region);
        backgroundPowerSaver = new BackgroundPowerSaver(this);

        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setOnItemClickListener(this);
    }
//second comment added
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Log.d(TAG, "Here we go");
        int truePosition = position;

        Intent intent = new Intent(MainActivity.this, DestinationActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("position", truePosition);
        intent.putExtras(extras);
        this.startActivity(intent);
        Log.i(TAG, "OMG");

    }

    @Override
    public void didEnterRegion(Region ar0) {
        int p = 2;
    }

    @Override
    public void didExitRegion(Region ar0) {
        int p = 3;
    }

    @Override
    public void didDetermineStateForRegion(int state, Region ar0) {
        int p = 4;
    }

}