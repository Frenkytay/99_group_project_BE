package com.exercise.listingservice.dto;

import java.util.List;

public class GetPublicListingResponseDto {

        private boolean result ;
        private  List<PublicListingDto> listing;



    private  UserDto user;
    public boolean isResult() {
        return result;
    }

    public List<PublicListingDto> getListing() {
        return listing;
    }

    public void setListing(List<PublicListingDto> listing) {
        this.listing = listing;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
