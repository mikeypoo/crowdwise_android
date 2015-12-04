package com.mikedmcgowan.crowdwise;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by mike on 12/3/15.
 */
public class Crowdwise extends Application {
    private static Crowdwise crowdwise;
    private Bus bus;

    @Override public void onCreate() {
        super.onCreate();
        crowdwise = this;
        bus = new Bus();
    }

    public Bus getBus() {
        return this.bus;
    }

    public static Crowdwise getInstance() {
        return crowdwise;
    }
}
