package com.oopstudy.board.user.domain;

import com.oopstudy.board.user.exception.InvalidPhoneNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PhoneTest {
    private final String number = "010-1234-5678";

    @DisplayName("Phone 객체를 생성할 수 있다.")
    @Test
    void create() {
        Phone expect = new Phone(number);

        Phone actual = new Phone(number);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("빈 문자열이나 null이 들어올 경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(String input) {
        assertThatExceptionOfType(InvalidPhoneNumberException.class).isThrownBy(
                () -> new Phone(input)
        );
    }

    @DisplayName("핸드폰 형식에 맞지 않는 경우경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "010", "010-", "010+", "010*", "010,"
                          , "010-1", "010-12", "010+12"
                          , "010-1234-", "010-1234-1", "010-1234-12", "010-1234-123"})
    void isRightFormat(String input) {
        assertThatExceptionOfType(InvalidPhoneNumberException.class).isThrownBy(
                () -> new Phone(input)
        );
    }
}
