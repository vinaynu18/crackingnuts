package com.source.ctcigayle.StringRotation;

public class StringRotation_I {

    public static void main(String[] args) {
        String one = "waterbottle";
        String two = "erbottlewat";


        boolean isRotation = checkIfIsRotation(one, two);
        System.out.println("isRotation : " + isRotation);
    }

    private static boolean checkIfIsRotation(String one, String two) {

        // the point is to find an index where we need to do the SubString's
        // and then swap to (like in 0-i and then i-length(two))
        // and then concatenate and se eif the String matches..
        //time O(n) space
        if(one.length() != two.length())
            return false;//assuming there are no additional characters

        for(int i=0;i<two.length();i++){
            String subString1 = two.substring(0,i);
            String subString2 = two.substring(i,two.length());

            if(one.equals(subString2 + subString1)){
                return true;
            }
        }

        return false;
    }
}
