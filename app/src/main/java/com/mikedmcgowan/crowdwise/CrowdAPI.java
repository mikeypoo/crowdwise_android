package com.mikedmcgowan.crowdwise;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by mike on 12/3/15.
 */
public interface CrowdAPI {
    @GET("/listings/{listingId}") void getListing(@Path("listingId") int listingId, Callback<Listing> callback);
}
