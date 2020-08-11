package com.source.leetcode;

public class MaxProductThreeNumbers {
    public int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int n : nums){

            if(n <= min1){
                min2 = min1;
                min1 = n;
            }else if(n <= min2){
                min2 = n;
            }

            if(n >= max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n >= max2){
                max3 = max2;
                max2 = n;
            } else if(n >= max3){
                max3 = n;
            }

        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        System.out.println((new MaxProductThreeNumbers()).maximumProduct(new int[]{1,1,-4,3,3,6,3,9}));
    }
}