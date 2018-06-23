package com.kershless.api.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertTest {

    @Test
    public void notBlank_WithNullString_ShouldThrowException() {
        assertThatThrownBy(() -> Assert.notBlank(null, "foo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("foo");
    }

    @Test
    public void notBlank_WithEmptyString_ShouldThrowException() {
        assertThatThrownBy(() -> Assert.notBlank("", "foo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("foo");
    }


    @Test
    public void notBlank_WithOnlyWhiteSpacesString_ShouldThrowException() {
        assertThatThrownBy(() -> Assert.notBlank(" ", "foo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("foo");
    }

    @Test
    public void notBlank_WithNonBlankString_ShouldNotThrowException() {
        assertThatCode(() -> Assert.notBlank(" f", "foo"))
            .doesNotThrowAnyException();
    }
}
