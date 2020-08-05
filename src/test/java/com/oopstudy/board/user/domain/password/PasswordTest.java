package com.oopstudy.board.user.domain.password;

import com.oopstudy.board.user.domain.password.encrypt.Encryptable;
import com.oopstudy.board.user.domain.password.encrypt.SaltBCrypt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PasswordTest {

    private final Encryptable encrypt = new SaltBCrypt();

    @DisplayName("빈 문자열이나 null이 들어올 경우 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Password(encrypt, input)
        );
    }

    @DisplayName("비밀번호 형식이 맞지 않으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345", "1234567", "aaaabbbbccccdddde"})
    void validFormat(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Password(encrypt, input)
        );
    }
}
