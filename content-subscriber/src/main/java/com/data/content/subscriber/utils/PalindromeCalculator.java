package com.data.content.subscriber.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PalindromeCalculator {

public static int sizeOfLongestPalindrome(String string) {
        boolean table[][] = new boolean[string.length()][string.length()];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < string.length(); ++i)
            table[i][i] = true;

        for (int i = 0; i < string.length() - 1; ++i) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                table[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        for (int index = 3; index <= string.length(); ++index) {

            for (int subIndex = 0; subIndex < string.length() - index + 1; ++subIndex) {
                int currentIndex = subIndex + index - 1;

                if (table[subIndex + 1][currentIndex - 1] && string.charAt(subIndex) == string.charAt(currentIndex)) {
                    table[subIndex][currentIndex] = true;

                    if (index > maxLength) {
                        maxLength = index;
                    }
                }
            }
        }
        return maxLength;
    }
}
