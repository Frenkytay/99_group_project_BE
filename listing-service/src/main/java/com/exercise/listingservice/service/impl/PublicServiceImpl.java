package com.exercise.listingservice.service.impl;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.entity.Listing;
import com.exercise.listingservice.entity.User;
import com.exercise.listingservice.repository.ListingRepository;
import com.exercise.listingservice.repository.PublicRepository;
import com.exercise.listingservice.repository.UserRepository;
import com.exercise.listingservice.service.ListingService;
import com.exercise.listingservice.service.PublicService;
import com.exercise.listingservice.service.UserService;
import jakarta.validation.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    private PublicRepository publicRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ListingService listingService;
    public GetPublicListingResponseDto getListing(GetPublicListingRequestDto requestDto) {
        Pageable pageable = PageRequest.of(requestDto.getPageNum() - 1, requestDto.getPageSize(), Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<Listing> listingsPage;

        if (requestDto.getUserId() != null) {

            listingsPage = publicRepository.findByUserId(requestDto.getUserId(), pageable);
        } else {

            listingsPage = publicRepository.findAll(pageable);
        }


        List<PublicListingDto> listingDtos = listingsPage.getContent().stream()
                .map(listing -> {
                    PublicListingDto dto = new PublicListingDto();
                    dto.setId(listing.getId());
                    dto.setListingType(listing.getListingType());
                    dto.setPrice(listing.getPrice());
                    dto.setCreatedAt(listing.getCreatedAt());
                    dto.setUpdatedAt(listing.getUpdatedAt());



                    UserDto userDto = new UserDto();
                    GetUserByIdRequestDto request = new GetUserByIdRequestDto();
                    request.setId(listing.getUserId());
                    GetUserByIdResponseDto res = userService.getUserById(request);

                    if(res.isResult() == true){
                        dto.setUser(res.getUser());
                    }else{
                        dto.setUser(null);
                    }

                    return dto;
                })
                .collect(Collectors.toList());

        // Build response
        GetPublicListingResponseDto responseDto = new GetPublicListingResponseDto();
        responseDto.setResult(true);
        responseDto.setListing(listingDtos);

        return responseDto;
    }
    public CreatePublicUserResponseDto register(CreatePublicUserRequestDto requestDto){
        CreateUserRequestDto request = new CreateUserRequestDto();
        request.setName(requestDto.getName());
        CreateUserResponseDto  response = userService.register(request);

        CreatePublicUserResponseDto responseDto = new CreatePublicUserResponseDto();
        if(!response.isResult()){
            responseDto.setUser(null);
            return responseDto;
        }
        responseDto.setUser(response.getUser());
        return responseDto;
    }
    public  CreatePublicListingResponseDto createListing(CreatePublicListingRequestDto requestDto){
        CreateListingRequestDto request = new CreateListingRequestDto();
        request.setListingType(requestDto.getListingType());
        request.setPrice(requestDto.getPrice());
        request.setUserId(requestDto.getUserId());


        CreateListingResponseDto listingResponse = listingService.createListing(request);

        CreatePublicListingResponseDto response = new CreatePublicListingResponseDto();
        if(!listingResponse.isResult()){
            response.setListing(null);
            return response;
        }
        System.out.println();
        response.setListing(listingResponse.getListing());

        return response;

    }


}
