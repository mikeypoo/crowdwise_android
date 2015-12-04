package com.mikedmcgowan.crowdwise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private CrowdService crowdService;
    private Bus bus;
    private TextView helloText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bus = Crowdwise.getInstance().getBus();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        crowdService = new CrowdService();
        helloText = (TextView) findViewById(R.id.hello);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crowdService.getListing(1);
            }
        });
    }

    @Override protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Subscribe
    public void onListingRetrieved(ListingRetrievedEvent event) {
        helloText.setText(event.getListing().getName());
    }


}
