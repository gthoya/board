package com.oopstudy.board.user.domain.password.encrypt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SaltBCryptTest {

    private final String password = "abcd";
    private final int round = 4;

    @DisplayName("비밀번호를 bcrypt 방법으로 암호화 할 수 있다.")
    @Test
    void encrypt() {
        Encryptable encrypt = new SaltBCrypt();

        final String actualEncrypted = encrypt.encrypt(password);

        assertThat(encrypt.isMatch(password, actualEncrypted)).isTrue();
    }

    @DisplayName("비밀번호를 4번 반복하여 암호화 할 수 있다.")
    @Test
    void encryptFour() {
        Encryptable encrypt = new SaltBCrypt();

        final String actualEncrypted = encrypt.encrypt(password, round);

        assertThat(encrypt.isMatch(password, actualEncrypted)).isTrue();
    }
}
