package com.oopstudy.board.user.service;

import com.oopstudy.board.user.controller.dto.SignUpRequestDto;
import com.oopstudy.board.user.controller.dto.SignUpResponseDto;
import com.oopstudy.board.user.domain.Email;
import com.oopstudy.board.user.domain.Phone;
import com.oopstudy.board.user.domain.User;
import com.oopstudy.board.user.domain.password.Password;
import com.oopstudy.board.user.domain.password.encrypt.SaltBCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public SignUpResponseDto signUp(final SignUpRequestDto signUpRequestDto) {
        Email email = new Email(signUpRequestDto.getAddress());
        Password password = new Password(new SaltBCrypt(), signUpRequestDto.getPassword());
        Phone phone = new Phone(signUpRequestDto.getPhoneNumber());
        User user = new User(email, password, phone);
        return new SignUpResponseDto(user);
    }
}
