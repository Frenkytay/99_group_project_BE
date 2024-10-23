package com.exercise.listingservice.controller;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.service.PublicService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public-api")
public class PublicAPIController {
    @Autowired
    private PublicService publicService;
    @GetMapping("/listings")
    public GetPublicListingResponseDto getAllListing(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize,
            @RequestParam(name = "userId", required = false) @Min(1) Integer userId
    ) {
        GetPublicListingRequestDto requestDto = new GetPublicListingRequestDto();
        requestDto.setPageNum(pageNum);
        requestDto.setPageSize(pageSize);
        requestDto.setUserId(userId);
        return publicService.getListing(requestDto);

    }
    @PostMapping("/listings")
    public CreatePublicListingResponseDto createListing(@Valid CreatePublicListingRequestDto requestDto){
        CreatePublicListingRequestDto request = new CreatePublicListingRequestDto();
        request.setPrice(requestDto.getPrice());
        request.setListingType(requestDto.getListingType());
        request.setUserId(requestDto.getUserId());
        return publicService.createListing(request);
    }
    @PostMapping("/user")
    public CreatePublicUserResponseDto createUser( @RequestParam(name = "name", defaultValue = "")  String name){
        CreatePublicUserRequestDto request = new CreatePublicUserRequestDto();
        request.setName(name);
        return publicService.register(request);
    }
}
