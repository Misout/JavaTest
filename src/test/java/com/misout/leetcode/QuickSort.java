package com.misout.leetcode;

import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-16 19:29:44
 */
public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if(nums == null || nums.length < 1) return;
        int baseNumber = nums[start];
        int i = start, j = end;
        while(i < j) {
            while(i < j) {
                if(nums[j] < baseNumber) {
                    break;
                }
                j--;
            }

            while(i < j) {
                if(nums[i] > baseNumber) {
                    break;
                }
                i++;
            }
            if(i != j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        if(i > start && i <= end) {
            quickSort(nums, start, i-1);
        }
        if(j >= start && j < end) {
            quickSort(nums, i + 1, end);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test_quickSort() {
        int[] nums = {3,2,1,5,6,4};
        quickSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }
}
