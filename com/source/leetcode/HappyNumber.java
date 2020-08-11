package com.source.leetcode;

import java.util.HashMap;

class HappyNumber {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
        if(n<0)
            return false;

        int temp;
        int nextNumber=0;
        while(n>0){
            temp = n%10;
            nextNumber = nextNumber + (temp * temp);
            n = n/10;
            if(n == 0){
                if(seen.containsKey(nextNumber)){
                    return false;
                }else{
                    seen.put(Integer.valueOf(nextNumber), Boolean.TRUE);
                }
                if(nextNumber == 1)
                    return true;
                n = nextNumber;
                nextNumber = 0;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println((new HappyNumber()).isHappy(123));
        System.out.println((new HappyNumber()).isHappy(19));
        System.out.println((new HappyNumber()).isHappy(11));
    }
}