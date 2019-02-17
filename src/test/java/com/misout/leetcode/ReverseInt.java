package com.misout.leetcode;

import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-17 17:26:36
 */
public class ReverseInt {
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] chs = s.toCharArray();
        if(x > 0) {
            reverse(chs, 0, chs.length-1);
        } else {
            reverse(chs, 1, chs.length-1);
        }
        String newS = new String(chs);
        return Integer.valueOf(newS);
    }

    public int reverse2(int x) {
        int result = 0;

        int maxValue = Integer.MAX_VALUE / 10;
        int minValue = Integer.MIN_VALUE / 10;
        while(x != 0) {
            int pop = x % 10;
            x = x / 10;
            if(result > maxValue || (result == maxValue && pop > 7)) {
                return 0;
            } else if(result < minValue || (result == minValue && pop < -8)) {
                return 0;
            } else {
                result = result * 10 + pop;
            }
        }
        return result;
    }

    public void reverse(char[] chs, int start, int end) {
        if((end - start) < 1) return;
        int i = start;
        int j = end;
        int endIndex = (start + end) / 2;
        while(i <= endIndex) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test_reverse() {
        char[] chs = {'-', '3', '2', '1'};
        reverse(chs, 1, 3);
        System.out.println(chs);
        chs = new char[]{'3', '2', '1'};
        reverse(chs, 0, 2);
        System.out.println(chs);
    }

    @Test
    public void test_reverse2() {
        System.out.println(reverse2(1463847412));
    }
}
