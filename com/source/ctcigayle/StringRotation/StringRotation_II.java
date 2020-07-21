package com.source.ctcigayle.StringRotation;

public class StringRotation_II {

    public static void main(String[] args) {
        String one = "waterbottle";
        String two = "erbottlewat";


        boolean isRotation = checkIfIsRotation(one, two);
        System.out.println("isRotation : " + isRotation);
    }

    private static boolean checkIfIsRotation(String one, String two) {

        //if we Concatenate the String two to itself and then find the indexOf(one).. ??
        // time O(1) space O(1) to me
        // CTCI book says time complexity is O(A+B) where A and B are the lengths of the two strings respectively - this is due to the existence of the subString method..

        String twoDoubled = two+two;
        if(twoDoubled.indexOf(one)>-1)
            return true;

        return false;
    }

    //added a comment for the Asana Integration - https://app.asana.com/0/1184183482952257/1185182097504391
    //testing again
}
