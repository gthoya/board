package com.oopstudy.board.user.service;

import com.oopstudy.board.user.controller.dto.SignUpRequestDto;
import com.oopstudy.board.user.controller.dto.SignUpResponseDto;
import com.oopstudy.board.user.domain.Email;
import com.oopstudy.board.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    private final SignUpRepository signUpRepository;
//
//    public SignUpService(final SignUpRepository signUpRepository) {
//        this.signUpRepository = signUpRepository;
//    }

    public SignUpResponseDto signUp(final SignUpRequestDto signUpRequestDto) {
        Email email = new Email(signUpRequestDto.getAddress());
        User user = new User(email);
        //new SignUpResponseDto(signUpRepository.save(user));
        return new SignUpResponseDto(user);
    }
}
