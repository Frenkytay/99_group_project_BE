package com.exercise.listingservice.dto;

public class CreateUserResponseDto {
    private boolean result;
    private UserDto user;



    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
}
