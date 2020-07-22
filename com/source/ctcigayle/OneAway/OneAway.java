package com.source.ctcigayle.OneAway;

public class OneAway {


    public static void main(String[] args) {
        System.out.println("isOneAway :" + OneAway.isOneAway("fista","fist"));//true
        System.out.println("isOneAway :" + OneAway.isOneAway("fistaaa","fist"));//false
        System.out.println("isOneAway :" + OneAway.isOneAway("fist","fista"));//true
        System.out.println("isOneAway :" + OneAway.isOneAway("fist","fistaa"));//false
        System.out.println("isOneAway :" + OneAway.isOneAway("pale","ple"));//true
        System.out.println("isOneAway :" + OneAway.isOneAway("pales","pale"));//true
        System.out.println("isOneAway :" + OneAway.isOneAway("pale","bae"));//false
    }

    private static boolean isOneAway(String first, String second) {

        boolean insertionRequired = false;
        boolean deletionRequired = false;
        boolean replacementRequired = false;
        int i=0;int j=0;
        if(first.length() == second.length()){
            while(i<first.length() && j< second.length()){
                if(!(first.charAt(i) == second.charAt(j))){
                    if(replacementRequired){
                        return false;
                    }
                    replacementRequired = true;
                }
                i++;j++;
            }
        }else{
            while(i<first.length() && j< second.length()){
                if(!(first.charAt(i) == second.charAt(j))){
                    if(deletionRequired || insertionRequired){
                        return false;
                    }
                    if(first.length() > second.length()){
                        deletionRequired = true;
                        i++;
                    }else{
                        insertionRequired = true;
                        j++;
                    }
                }
                i++;j++;
            }

            if(deletionRequired){
                if(first.length() - i > 0){
                    return false;
                }
            }else if(insertionRequired){
                if(second.length() -j > 0)
                    return false;
            }else{
                if(first.length() - i > 1 || second.length() - j > 1)
                    return false;
            }

        }

        return true;
    }
}
