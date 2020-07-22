package com.source.ctcigayle.CheckPermutation;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation_Fastest {

    public static void main(String[] args) {
        System.out.println("isPermutation : " + CheckPermutation_Fastest.checkIfStringsArePermutations("water","teraw"));
        System.out.println("isPermutation : " + CheckPermutation_Fastest.checkIfStringsArePermutations("zampack","ckmzapa"));
        System.out.println("isPermutation : " + CheckPermutation_Fastest.checkIfStringsArePermutations("robert",""));
        System.out.println("isPermutation : " + CheckPermutation_Fastest.checkIfStringsArePermutations("tom","mot"));
    }

    private static boolean checkIfStringsArePermutations(String s, String t) {

        if(!(s.length() == t.length())){
            return false;

        }

        HashMap<Character, Integer> sMap = new HashMap();
        char[] sChars = s.toCharArray();
        for(char c: sChars){
            insertIntoSMap(c, sMap);
        }

        for(int i=0;i<t.length();i++){
            char tChar = t.charAt(i);
            if(sMap.containsKey(tChar)){
                removeCharFromSMap(tChar, sMap);
            }
        }

        return sMap.size() == 0;
    }

    private static void removeCharFromSMap(char tChar, HashMap<Character, Integer> sMap) {
        if(sMap.get(tChar) == 1){
            sMap.remove(tChar);
        }else{
            sMap.put(tChar, sMap.get(tChar) -1);
        }
    }

    private static void insertIntoSMap(char c, HashMap<Character, Integer> sMap) {
        if(sMap.containsKey(c)){
            sMap.put(c, sMap.get(c) + 1);
        }else{
            sMap.put(c,1);
        }
    }
}
