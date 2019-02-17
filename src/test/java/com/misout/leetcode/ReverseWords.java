package com.misout.leetcode;

import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-16 14:29:02
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if(s == null || "".equals(s)) return "";
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String word = reverseString(words[i]);
            builder.append(word).append(" ");
        }
        return builder.substring(0, builder.length()-1);
    }

    private String reverseString(String s) {
        if(s == null || "".equals(s)) return "";
        char[] chs = s.toCharArray();
        int index = 0;
        int endIndex = chs.length / 2;
        while(index < endIndex) {
            int rightIndex = chs.length - index - 1;
            swapChar(chs, index, rightIndex);
            index++;
        }
        return new String(chs);
    }

    private void swapChar(char[] s, int leftIndex, int rightIndex) {
        char temp = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = temp;
    }

    @Test
    public void test_reverseWords() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
