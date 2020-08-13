package com.source.algoexpert.UnderScorifyString;

import java.util.*;

class UnderScorifyString {

    public static void main(String[] args) {
        //UnderScorifyString
        System.out.println(UnderScorifyString.underscorifySubstring("testthis is a testtest to see if testestest it works","test"));
        //  _test_this is a _testtest_ to see if _testestest_ it works is expected
    }
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        List<Integer[]> locations = getLocations(str, substring);
        List<Integer> finalLocations = getFinalLocations(locations);
        String finalString = getFinalString(str, finalLocations);
        return finalString;
    }

    private static List<Integer[]> getLocations(String str, String substring){
        List<Integer[]> locations = new ArrayList<>();

        int startIndex = 0;
        while(startIndex < str.length()){
            int foundIndex = str.indexOf(substring, startIndex);
            if(foundIndex != -1){
                Integer[] locs = new Integer[2];
                locs[0] = foundIndex;
                locs[1] = foundIndex + substring.length();
                locations.add(locs);
                startIndex = foundIndex + 1;
            }else{
                break;
            }
        }

        return locations;
    }

    private static List<Integer> getFinalLocations(List<Integer[]> locations){
        List<Integer> finalLocs = new ArrayList<>();
        if(locations.size() == 0){
            return new ArrayList<>();
        }

        int previousRightloc = -1;
        for(Integer[] locs : locations){
            if(locs[0] <= previousRightloc){
                finalLocs.set(finalLocs.size()-1, locs[1]);// set not add
            }else{
                finalLocs.add(locs[0]);
                finalLocs.add(locs[1]);
            }
            previousRightloc = locs[1];
        }

        return finalLocs;
    }

    private static String getFinalString(String str, List<Integer> finalLocations){
        StringBuilder finalString = new StringBuilder();
        int startIndex = 0;
        int locListLocation = 0;
        while(startIndex < str.length() && locListLocation < finalLocations.size()){
            if(startIndex == finalLocations.get(locListLocation)){
                finalString.append("_");
                locListLocation++;
            }
            finalString.append(str.charAt(startIndex));
            startIndex++;
        }

        //edge case where substring is at the end of str
        if(locListLocation < finalLocations.size()){
            finalString.append("_");
        }

        //edge case where substring is not at the end of the str
        if(startIndex < str.length()){
            finalString.append(str, startIndex, str.length());
        }
        return finalString.toString();
    }
}

