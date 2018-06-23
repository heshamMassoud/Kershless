package com.kershless.api.util;


public final class Assert {
    /**
     * Assert that a String is not {@code null} and is not empty using the util
     * {@link org.springframework.util.StringUtils#hasText(String)}.
     * <pre class="code">Assert.notNull(clazz, "The class must not be null");</pre>
     *
     * @param string  the string to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the string is {@code null} or blank.
     */
    public static void notBlank(final String string, final String message) {
        if (!org.springframework.util.StringUtils.hasText(string)) {
            throw new IllegalArgumentException(message);
        }
    }

    private Assert() {
    }
}
