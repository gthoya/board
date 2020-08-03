package com.oopstudy.board.post;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PostStatusConverter implements AttributeConverter<PostStatus, String> {
    @Override
    public String convertToDatabaseColumn(PostStatus postStatus) {
        return postStatus.getCode();
    }

    @Override
    public PostStatus convertToEntityAttribute(String code) {
        return PostStatus.of(code);
    }
}
