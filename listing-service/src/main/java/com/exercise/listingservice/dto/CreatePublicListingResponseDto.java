package com.exercise.listingservice.dto;

public class CreatePublicListingResponseDto {
    private ListingDto listing;

    public ListingDto getListing() {
        return listing;
    }

    public void setListing(ListingDto listing) {
        this.listing = listing;
    }
}
