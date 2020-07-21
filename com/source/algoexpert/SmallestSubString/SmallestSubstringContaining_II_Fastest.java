package com.source.algoexpert.SmallestSubString;

import java.lang.reflect.Array;
import java.util.*;

class SmallestSubstringContaining_II_Fastest {

    public static void main(String[] args) {
        System.out.println(SmallestSubstringContaining_II_Fastest.smallestSubstringContaining("abcdef","fa"));
        System.out.println(SmallestSubstringContaining_II_Fastest.smallestSubstringContaining("abcd$ef$axb$c$","$$abf"));
        System.out.println(SmallestSubstringContaining_II_Fastest.smallestSubstringContaining("abcdef","d"));
        System.out.println(SmallestSubstringContaining_II_Fastest.smallestSubstringContaining("abcdefghijklmnopqrstuvwxyz","aajjttwwxxzz"));
    }
    // time complexity is O(B+S) where B is the length of big string and S is the length of the small string
    // space complexity is also the same O(B+S)

    public static String smallestSubstringContaining(String bigString, String smallString) {

        Map<Character, Integer> smallestSubStringCharMap = getSmallestSubStringCharMap(smallString);
        List<Integer> subStringBounds = getSubStringBounds(bigString, smallestSubStringCharMap);

        return getStringFromBounds(subStringBounds,bigString);
    }

    private static String getStringFromBounds(List<Integer> subStringBounds, String big) {
        Integer start = subStringBounds.get(0);
        Integer end = subStringBounds.get(1);
        if(start < 0 || end >= big.length()){
            return "";
        }
        return big.substring(start, end+1);
    }

    // main logic
    private static List<Integer> getSubStringBounds(String bigString, Map<Character, Integer> smallestSubStringCharMap) {

        List<Integer> bounds = new ArrayList<>();
        bounds.add(0);
        bounds.add(Integer.MAX_VALUE);
        int leftIndex=0; int rightIndex=0;
        Map<Character,Integer> characterCount = new HashMap<>();
        int uniqueCharacterCount=smallestSubStringCharMap.size();
        int uniqueCharacterCountDone=0;
        //rightIndex moving right
        while(rightIndex < bigString.length()){
            char c = bigString.charAt(rightIndex);
            if(!smallestSubStringCharMap.containsKey(c)){
                rightIndex++;
                continue;
            }

            increaseSmallCharCounts(c, characterCount);
            // increase this count when unique character count matches the original smallSubString character count
            if(characterCount.get(c).equals(smallestSubStringCharMap.get(c))){
                uniqueCharacterCountDone++;
            }

            //leftIndex moving right
            while(uniqueCharacterCountDone == uniqueCharacterCount && leftIndex <= rightIndex){

                bounds = getCloserBounds(leftIndex,rightIndex,bounds.get(0),bounds.get(1));
                char leftChar = bigString.charAt(leftIndex);

                if(!smallestSubStringCharMap.containsKey(leftChar)){
                    leftIndex++;
                    continue;
                }
                // decrease this count when unique character count matches the original smallSubString character count
                //IMPORTANT
                if(characterCount.get(leftChar).equals(smallestSubStringCharMap.get(leftChar))){
                    uniqueCharacterCountDone--;
                }
                decreaseSmallCharCounts(leftChar, characterCount);
                leftIndex++;
            }
            rightIndex++;
        }

        return bounds;
    }

    private static void decreaseSmallCharCounts(char c, Map<Character, Integer> characterCount) {
        if(characterCount.containsKey(c)){
            if(characterCount.get(c) == 1){
                characterCount.remove(c);
            }else{
                characterCount.put(c, characterCount.get(c) - 1);
            }
        }
    }

    private static List<Integer> getCloserBounds(int leftIndex, int rightIndex, Integer left, Integer right) {
        if(rightIndex-leftIndex < right - left){
            return new ArrayList<Integer>(Arrays.asList(leftIndex,rightIndex));
        }else{
            return new ArrayList<Integer>(Arrays.asList(left,right));
        }
    }

    private static Map<Character, Integer> getSmallestSubStringCharMap(String smallString) {

        Map<Character, Integer> charCountsMap = new HashMap<>();
        for(int i=0;i<smallString.length();i++){
            increaseSmallCharCounts(smallString.charAt(i), charCountsMap);
        }

        return charCountsMap;
    }

    private static void increaseSmallCharCounts(char charAt, Map<Character, Integer> charCountsMap) {
        if(charCountsMap.containsKey(charAt)){
            charCountsMap.put(charAt, charCountsMap.get(charAt) + 1);
        }else{
            charCountsMap.put(charAt,1);
        }
    }


}

