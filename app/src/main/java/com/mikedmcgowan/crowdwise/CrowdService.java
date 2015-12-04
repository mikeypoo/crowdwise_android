package com.mikedmcgowan.crowdwise;

import android.util.Log;

import com.squareup.otto.Bus;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by mike on 12/3/15.
 */
public class CrowdService {
    private CrowdAPI crowdAPI;
    private String crowdApiBaseUrl = "http://10.0.3.2:4567";
    private Bus bus;

    public void getListing(int listingId) {
        getCrowdAPI().getListing(listingId, new Callback<Listing>() {
            @Override
            public void success(Listing listing, Response response) {
                getBus().post(new ListingRetrievedEvent(listing));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("butts", error.toString());
            }
        });
    }


    public CrowdAPI getCrowdAPI() {
        if (crowdAPI == null) {
            crowdAPI = new RestAdapter.Builder()
                    .setEndpoint(crowdApiBaseUrl)
                    .build()
                    .create(CrowdAPI.class);
            return crowdAPI;
        } else {
            return crowdAPI;
        }
    }

    private Bus getBus() {
        if (bus == null) {
            bus = Crowdwise.getInstance().getBus();
        }
        return bus;
    }

}
