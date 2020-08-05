package com.oopstudy.board.user.domain;

import com.oopstudy.board.user.exception.InvalidPhoneNumberException;
import com.oopstudy.board.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class Phone {
    private static final Pattern PATTERN = Pattern.compile("^\\d{3}-\\d{3,4}-\\d{4}$");

    private final String number;

    public Phone(final String number) {
        validEmpty(number);
        validFormat(number);
        this.number = number;
    }

    private void validFormat(final String number) {
        if (!PATTERN.matcher(number).matches()) {
            throw new InvalidPhoneNumberException("핸드폰 번호 형식이 아닙니다.");
        }
    }

    private void validEmpty(final String number) {
        if (StringUtils.isEmpty(number)) {
            throw new InvalidPhoneNumberException("핸드폰 번호가 비어있습니다.");
        }
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
