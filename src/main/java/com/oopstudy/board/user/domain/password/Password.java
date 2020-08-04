package com.oopstudy.board.user.domain.password;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oopstudy.board.user.domain.password.encrypt.Encryptable;
import com.oopstudy.board.util.StringUtils;

import java.util.regex.Pattern;

public class Password {
    private static final Pattern PATTERN = Pattern.compile("^.*(?=^.{8,16}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$");

    private final Encryptable encrypt;

    @JsonIgnore
    private final String encryptedPassword;

    public Password(final Encryptable encrypt, final String value) {
        validEmpty(value);
        validFormat(value);
        this.encrypt = encrypt;
        this.encryptedPassword = encrypt.encrypt(value);
    }

    private void validEmpty(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("비밀번호가 빌 수 없습니다.");
        }
    }

    private void validFormat(final String value) {
        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("비밀번호 형식에 어긋납니다.");
        }
    }
}
