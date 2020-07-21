package com.source.algoexpert.SmallestSubString;

import java.util.*;

class SmallestSubstringContaining {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        String smallestSubString = "";
        int smallestSubStringLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> smallStringCharMap = getSmallStringCharacterIntegerHashMap(smallString);

        int i=0;
        while (i < bigString.length() - smallString.length() + 1) {
            int leftProbableIndex = i;
            HashMap<Character, Integer> currentHashMap = new HashMap();
            currentHashMap.putAll(smallStringCharMap);
            //int rightprobableIndex = i;
            int j=i;
            while (j<bigString.length()) {
                if(currentHashMap.containsKey(bigString.charAt(j))){

                    int countVal = currentHashMap.get(bigString.charAt(j));
                    if(countVal ==1) {
                        removeCharFromMap(bigString, currentHashMap, j);
                    } else
                        putCharInMap(bigString, currentHashMap, j, countVal-1);

                }

                if(currentHashMap.size() == 0){
                    // subString matched
                    if(bigString.substring(i,j+1).length() < smallestSubStringLength){
                        smallestSubString = bigString.substring(i,j+1);
                        smallestSubStringLength = bigString.substring(i,j+1).length();
                    }

                }

                j++;
            }
            i++;
        }

        return smallestSubString;
    }

    private static HashMap<Character, Integer> getSmallStringCharacterIntegerHashMap(String smallString) {
        HashMap<Character, Integer> smallStringCharMap = new HashMap<>();
        for(int i=0;i<smallString.length();i++){
            if(smallStringCharMap.containsKey(smallString.charAt(i))){
                updateCharInMap(smallString, smallStringCharMap, i);
            }else{
                putCharInMap(smallString, smallStringCharMap, i, 1);
            }
        }
        return smallStringCharMap;
    }

    private static void removeCharFromMap(String bigString, HashMap<Character, Integer> currentHashMap, int j) {
        currentHashMap.remove(bigString.charAt(j));
    }

    private static void putCharInMap(String smallString, HashMap<Character, Integer> smallStringCharMap, int i, int i2) {
        smallStringCharMap.put(smallString.charAt(i), i2);
    }

    private static void updateCharInMap(String smallString, HashMap<Character, Integer> smallStringCharMap, int i) {
        int currentValue = smallStringCharMap.get(smallString.charAt(i));
        putCharInMap(smallString, smallStringCharMap, i, currentValue+1);
    }


    public static void main(String[] args) {
        System.out.println(SmallestSubstringContaining.smallestSubstringContaining("abzacdwejxjftghiwjtklmnopqrstuvwxyz", "aajjttwwxxzz"));
    }
}

