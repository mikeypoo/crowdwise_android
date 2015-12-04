package com.mikedmcgowan.crowdwise;

/**
 * Created by mike on 12/3/15.
 */
public class ListingRetrievedEvent {
    private Listing listing;

    public ListingRetrievedEvent(Listing listing) {
        this.listing = listing;
    }

    public Listing getListing() {
        return this.listing;
    }
}
