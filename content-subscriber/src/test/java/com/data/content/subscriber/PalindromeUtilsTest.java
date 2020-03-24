package com.data.content.subscriber.configuration;


import com.data.content.subscriber.utils.PalindromeCalculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeUtilsTest {
    @Test
    public void testPalindromes() {
        assertThat(PalindromeCalculator.sizeOfLongestPalindrome("malayalam")).isEqualTo(9);
        assertThat(PalindromeCalculator.sizeOfLongestPalindrome("abracadabra")).isEqualTo(3);
        assertThat(PalindromeCalculator.sizeOfLongestPalindrome("ask")).isEqualTo(1);

    }
}
