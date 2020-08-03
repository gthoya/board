package com.oopstudy.board.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostStatusTest {
    @Test
    public void testPostStatusIsValid() {
        Assertions.assertEquals(PostStatus.TEMP, PostStatus.of("T"));
        Assertions.assertEquals(PostStatus.PUBLISH, PostStatus.of("P"));
    }

    @Test
    public void testPostStatusIsNotValid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PostStatus.of("A"));
    }
}
