package com.exercise.listingservice.dto;

import java.util.List;

public class GetUserReponseDto {
    private boolean result;
    private List<UserDto> user;


    public List<UserDto> getUser() {
        return user;
    }

    public void setUser(List<UserDto> user) {
        this.user = user;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }


}
