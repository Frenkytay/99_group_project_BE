package com.exercise.listingservice.service;

import com.exercise.listingservice.dto.*;
import org.springframework.stereotype.Service;


public interface PublicService {
    GetPublicListingResponseDto getListing(GetPublicListingRequestDto requestDto);
    CreatePublicListingResponseDto createListing(CreatePublicListingRequestDto requestDto);
    CreatePublicUserResponseDto register(CreatePublicUserRequestDto requestDto);
}
