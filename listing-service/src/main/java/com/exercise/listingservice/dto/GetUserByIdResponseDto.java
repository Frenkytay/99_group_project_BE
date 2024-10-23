package com.exercise.listingservice.dto;
import java.util.List;
public class GetUserByIdResponseDto {
    private boolean result;

    public UserDto getUser() {
        return user;
    }

    private UserDto user;


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
