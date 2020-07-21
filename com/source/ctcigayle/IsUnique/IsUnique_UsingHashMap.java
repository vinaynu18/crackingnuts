package com.source.ctcigayle.IsUnique;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class IsUnique_UsingHashMap {

    public IsUnique_UsingHashMap() {
    }

    public static void main(String[] args) {
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("abcde"));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique(""));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("   "));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("abcade"));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("aaaaaa"));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("cat%^*"));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("catistrong"));
        System.out.println(IsUnique_UsingHashMap.checkIfUnique("catis_strong"));
    }
    // convert String to a char Array
    // and loop through every charecter and store it in the HashMap
    //if HashMap.containskey(c)  == true ; then return false
    public static boolean checkIfUnique(String str) {


        HashMap charMap = new HashMap<Character, Boolean>();
        char[] chars = str.toCharArray();
        for(char c: chars){
            if(charMap.containsKey(c)){
                return false;
            }else{
                charMap.put(c,true);
            }
        }

        return true;
    }
}
