package com.exercise.listingservice.controller;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.service.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public CreateUserResponseDto register(
            @RequestParam(name = "name", defaultValue = "")  String name
    ){
        CreateUserRequestDto request = new CreateUserRequestDto();
        request.setName(name);
        return userService.register(request);
    }
    @GetMapping("/user")
    public GetUserReponseDto getAllUser(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize)
    {
        GetUserRequestDto request = new GetUserRequestDto();
        request.setPageNum(pageNum-1);
        request.setPageSize(pageSize);
        return userService.getAllUser(request);
    }
    @GetMapping("/user/{id}")
    public GetUserByIdResponseDto getUserById(
            @PathVariable Integer id
    ){
        GetUserByIdRequestDto request = new GetUserByIdRequestDto();
        request.setId(id);
        return userService.getUserById(request);
    }



}
