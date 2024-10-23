package com.exercise.listingservice.service;


import com.exercise.listingservice.dto.*;

import com.exercise.listingservice.dto.GetUserReponseDto;
import com.exercise.listingservice.entity.Listing;
import com.exercise.listingservice.entity.User;
import com.exercise.listingservice.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;


public interface UserService {
   CreateUserResponseDto register(CreateUserRequestDto requestDto);
   GetUserReponseDto getAllUser(GetUserRequestDto requestDto );
   GetUserByIdResponseDto getUserById(GetUserByIdRequestDto requestDto);
}
