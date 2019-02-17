package com.misout.leetcode;

import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-17 16:21:32
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)) return "";
        if(s.length() < 2) return "";
        char[] chs = s.toCharArray();
        int maxLen = 1;
        String maxStr = "";
        for(int i = 0; i < chs.length; i++) {
            int j = i + 1;
            int maxSubLen = 1;
            String maxSubStr = "";
            while(j < chs.length) {
                if(ifPalindrome(chs, i, j)) {
                    maxSubLen = j - i + 1;
                    maxSubStr = new String(chs, i, j);
                }
                j++;
            }
            if(maxSubLen > maxLen) {
                maxLen = maxSubLen;
                maxStr = maxSubStr;
            }
        }
        if(maxLen == 1) {
            maxStr = "";
        }
        return maxStr;
    }

    public boolean ifPalindrome(char[] chs, int i, int j) {
        int start = i, end = j;
        while(start < end) {
            if(chs[start] != chs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test_ifPalindrome() {
        char[] chs = {'a', 'b'};
        System.out.println(ifPalindrome(chs, 0, 1));
        chs = new char[]{'a', 'b', 'a','c'};
        System.out.println(ifPalindrome(chs, 0, 2));
        System.out.println(ifPalindrome(chs, 1, 3));
    }

    @Test
    public void test_longestPalindrome() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
