package com.oopstudy.board.user.domain;

import com.oopstudy.board.user.exception.InvalidEmailException;
import com.oopstudy.board.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern PATTERN = Pattern.compile("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+");
    private static final String EMAIL_DELIMITER = "@";

    private final String address;

    public Email(String address) {
        validEmpty(address);
        validLength(address);
        validFormat(address);

        this.address = address;
    }

    private void validLength(final String address) {
        if (address.length() < 4 || address.length() > 50) {
            throw new InvalidEmailException("이메일은 최소 4자, 최대 50자입니다.");
        }
    }

    private void validEmpty(final String address) {
        if (StringUtils.isEmpty(address)) {
            throw new InvalidEmailException("빈 문자열이나 null이 들어올 수 없습니다.");
        }
    }

    private void validFormat(final String address) {
        if (!PATTERN.matcher(address).matches()) {
            throw new InvalidEmailException("이메일 형식이 아닙니다.");
        }
    }

    public String getAddress() {
        return address;
    }

    String getName() {
        String[] tokens = address.split(EMAIL_DELIMITER);
        return tokens[0];
    }

    String getDomain() {
        String[] tokens = address.split(EMAIL_DELIMITER);
        return tokens[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
