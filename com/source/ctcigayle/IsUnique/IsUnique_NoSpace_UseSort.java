package com.source.ctcigayle.IsUnique;

import java.util.Arrays;

public class IsUnique_NoSpace_UseSort {

    public IsUnique_NoSpace_UseSort() {
    }

    public static void main(String[] args) {
        boolean isUnique = checkIfUnique("abcde");
        System.out.println("isUnique : " + isUnique);
    }
    public static boolean checkIfUnique(String str) {


        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        char previous = ' ';
        for(char c: charArray){
            if(previous == c)
                return false;
            else
                previous = c;

        }

        return true;
    }
}
