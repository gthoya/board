package com.oopstudy.board.user.domain.password.encrypt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class SaltBCrypt implements Encryptable {

    @Override
    public String encrypt(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String encrypt(final String password, final int round) {
        return BCrypt.hashpw(password, BCrypt.gensalt(round));
    }

    @Override
    public boolean isMatch(final String password, final String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
