package com.source.ctcigayle.IsUnique;

import java.util.HashMap;

public class IsUnique_UsingHashMap {

    public IsUnique_UsingHashMap() {
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
