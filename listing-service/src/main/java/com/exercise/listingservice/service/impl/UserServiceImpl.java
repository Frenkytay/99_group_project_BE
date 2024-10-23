package com.exercise.listingservice.service.impl;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.entity.Listing;
import com.exercise.listingservice.entity.User;
import com.exercise.listingservice.repository.UserRepository;
import com.exercise.listingservice.service.UserService;
import jakarta.validation.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;
    public CreateUserResponseDto register(CreateUserRequestDto requestDto){
        User user = new User();
        user.setName(requestDto.getName());
        final Long timestampInMicroSecond = nowInEpochMicroSecond();
        user.setCreatedAt(timestampInMicroSecond);
        user.setUpdatedAt(timestampInMicroSecond);
        userRepository.save(user);
        CreateUserResponseDto response = new CreateUserResponseDto();
        response.setResult(true);
        response.setUser(convertUserToUserDto(user) );
        return response;
    }
    public GetUserReponseDto getAllUser(GetUserRequestDto requestDto){
        PageRequest pageRequest = PageRequest.of(requestDto.getPageNum(),
                requestDto.getPageSize(), Sort.by("createdAt").descending()
        );
        Page<User> userPage = userRepository.findAll(pageRequest);
        GetUserReponseDto response = new GetUserReponseDto();
        response.setResult(true);
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userPage.getContent()) {

            UserDto userDTO = new UserDto();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setUpdatedAt(user.getUpdatedAt());
            userDTO.setCreatedAt(user.getCreatedAt());
            System.out.println(user.getId());
            userDtoList.add(userDTO);
        }

        response.setUser(userDtoList);



        return response;
    }
    public GetUserByIdResponseDto getUserById(GetUserByIdRequestDto requestDto){
        Optional<User> user = userRepository.findById(requestDto.getId());
        GetUserByIdResponseDto response = new GetUserByIdResponseDto();
        if(!user.isPresent()){
            response.setResult(false);
            response.setUser(null);
            return response;
        }
        //masih error disini
        // by id tapi tinggal bagian search by id
        User users = user.get();
        response.setResult(true);

        response.setUser(convertUserToUserDto(users));

        return response;
    }
    private List<UserDto> convertUserListToUserDtoList(Optional<User> users) {
        return users.stream()
                .map(this::convertUserToUserDto) // Convert each User to UserDto
                .collect(Collectors.toList()); // Collect results into a List<UserDto>
    }


    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    private Long nowInEpochMicroSecond() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}
