package com.source.ctcigayle.IsUnique;

import java.util.Arrays;

public class IsUnique_NoSpace_UseSort {

    public IsUnique_NoSpace_UseSort() {
    }

    public static void main(String[] args) {
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("abcde"));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique(""));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("   "));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("abcade"));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("aaaaaa"));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("cat%^*"));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("catistrong"));
        System.out.println(IsUnique_NoSpace_UseSort.checkIfUnique("catis_strong"));
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
