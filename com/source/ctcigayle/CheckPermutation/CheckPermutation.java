package com.source.ctcigayle.CheckPermutation;

import java.util.Arrays;

public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println("isPermutation : " + CheckPermutation.checkIfStringsArePermutations("water","teraw"));
        System.out.println("isPermutation : " + CheckPermutation.checkIfStringsArePermutations("zampack","ckmzapa"));
        System.out.println("isPermutation : " + CheckPermutation.checkIfStringsArePermutations("robert",""));
        System.out.println("isPermutation : " + CheckPermutation.checkIfStringsArePermutations("tom","mot"));
    }

    private static boolean checkIfStringsArePermutations(String water, String teraw) {

        if(!(water.length() == teraw.length())){
            return false;

        }

        // time complexity is O(nlog(n))
        // space complexity is O(F+S) where F and S are the length of the first and second strings
        char[] waterChars = water.toCharArray();
        Arrays.sort(waterChars);
        char[] terawChars = teraw.toCharArray();
        Arrays.sort(terawChars);
        int i=0;
        while(i<water.length() && i<teraw.length()){
            if(!(waterChars[i] == terawChars[i]))
                return false;
            i++;
        }

        return true;
    }
}
