package com.source.interviewcake.MergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        int myIndex = 0;
        int alicesIndex = 0;
        int mergedIndex = 0;

        int[] mergedArray = new int[myArray.length + alicesArray.length];

        while (myIndex < myArray.length && alicesIndex < alicesArray.length) {
            int myVal = myArray[myIndex];
            int alicesVal = alicesArray[alicesIndex];
            if (myVal < alicesVal) {
                mergedArray[mergedIndex] = myVal;
                myIndex++;
            } else {
                mergedArray[mergedIndex] = alicesVal;
                alicesIndex++;
            }
            mergedIndex++;
        }

        if (myIndex == myArray.length) {
            while (alicesIndex < alicesArray.length) {
                mergedArray[mergedIndex] = alicesArray[alicesIndex];
                mergedIndex++;
                alicesIndex++;
            }
        } else if (alicesIndex == alicesArray.length) {
            while (myIndex < myArray.length) {
                mergedArray[mergedIndex] = myArray[myIndex];
                mergedIndex++;
                myIndex++;
            }
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        System.out.println("actual array : " + Arrays.toString(actual));
    }
}


//  CODE copied from Interview Cake Editor
//import org.junit.Test;
//        import org.junit.runner.JUnitCore;
//        import org.junit.runner.Result;
//        import org.junit.runner.notification.Failure;
//
//        import static org.junit.Assert.*;
//
//public class Solution {
//
//    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {
//
//        // combine the sorted arrays into one large sorted array
//
//        int myIndex = 0;
//        int alicesIndex = 0;
//        int mergedIndex = 0;
//
//        int[] mergedArray = new int[myArray.length + alicesArray.length];
//
//        while(myIndex < myArray.length && alicesIndex < alicesArray.length){
//            int myVal = myArray[myIndex];
//            int alicesVal = alicesArray[alicesIndex];
//            if(myVal < alicesVal){
//                mergedArray[mergedIndex] = myVal;
//                myIndex++;
//            }else{
//                mergedArray[mergedIndex] = alicesVal;
//                alicesIndex++;
//            }
//            mergedIndex++;
//        }
//
//        if(myIndex == myArray.length){
//            while(alicesIndex < alicesArray.length){
//                mergedArray[mergedIndex] = alicesArray[alicesIndex];
//                mergedIndex++;
//                alicesIndex++;
//            }
//        }else if(alicesIndex == alicesArray.length){
//            while(myIndex < myArray.length){
//                mergedArray[mergedIndex] = myArray[myIndex];
//                mergedIndex++;
//                myIndex++;
//            }
//        }
//
//        return mergedArray;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    // tests
//
//    @Test
//    public void bothArraysAreEmptyTest() {
//        final int[] myArray = {};
//        final int[] alicesArray = {};
//        final int[] expected = {};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void firstArrayIsEmptyTest() {
//        final int[] myArray = {};
//        final int[] alicesArray = {1, 2, 3};
//        final int[] expected = {1, 2, 3};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void secondArrayIsEmptyTest() {
//        final int[] myArray = {5, 6, 7};
//        final int[] alicesArray = {};
//        final int[] expected = {5, 6, 7};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void bothArraysHaveSomeNumbersTest() {
//        final int[] myArray = {2, 4, 6};
//        final int[] alicesArray = {1, 3, 7};
//        final int[] expected = {1, 2, 3, 4, 6, 7};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void arraysAreDifferentLengthsTest() {
//        final int[] myArray = {2, 4, 6, 8};
//        final int[] alicesArray = {1, 7};
//        final int[] expected = {1, 2, 4, 6, 7, 8};
//        final int[] actual = mergeArrays(myArray, alicesArray);
//        assertArrayEquals(expected, actual);
//    }
//
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(Solution.class);
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        if (result.wasSuccessful()) {
//            System.out.println("All tests passed.");
//        }
//    }
//}