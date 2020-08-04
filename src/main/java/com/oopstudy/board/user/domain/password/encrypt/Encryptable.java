package com.oopstudy.board.user.domain.password.encrypt;

public interface Encryptable {
    String encrypt(final String password);
    String encrypt(final String password, final int round);
    boolean isMatch(final String password, final String hash);
}
