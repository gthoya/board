package com.oopstudy.board.user.controller.dto;

public class SignUpRequestDto {
    private String address;
    private String password;
    private String phoneNumber;

    SignUpRequestDto() {}

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
