package com.oopstudy.board.user.domain;

import com.oopstudy.board.user.exception.InvalidEmailException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class EmailTest {
    private final String address = "otk1090@naver.com";

    @DisplayName("이메일 객체 생성을 성공한다.")
    @Test
    void create() {
        Email expect = new Email(address);

        Email actual = new Email(address);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("빈 문자열이나 null이 들어올 경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(String input) {
        assertThatExceptionOfType(InvalidEmailException.class).isThrownBy(
                () -> new Email(input)
        );
    }

    @DisplayName("이메일 주소가 4글자 이상 또는 50글자 이하가 아닐경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeef"})
    void checkLength(String input) {
        assertThatExceptionOfType(InvalidEmailException.class).isThrownBy(
                () -> new Email(input)
        );
    }

    @DisplayName("이메일 형식이 맞지않으면 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "asdf@naver", "asdf@@#$@$", "asdf@naver,com"})
    void checkFormat(String input) {
        assertThatExceptionOfType(InvalidEmailException.class).isThrownBy(
                () -> new Email(input)
        );
    }

    @DisplayName("전체 주소를 가지고올 수 있다.")
    @Test
    void getAddress() {
        String expect = new Email(address).getAddress();

        String actual = "otk1090@naver.com";

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("메일 이름을 가지고올 수 있다.")
    @Test
    void getName() {
        String expect = new Email(address).getName();

        String actual = "otk1090";

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("도메인을 가지고올 수 있다.")
    @Test
    void getDomain() {
        String expect = new Email(address).getDomain();

        String actual = "naver.com";

        assertThat(actual).isEqualTo(expect);
    }
}
