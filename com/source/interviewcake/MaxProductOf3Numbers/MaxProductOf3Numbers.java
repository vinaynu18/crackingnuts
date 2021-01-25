package com.source.interviewcake.MaxProductOf3Numbers;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MaxProductOf3Numbers {

    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers

        if(intArray.length < 3){
            throw new IllegalArgumentException("getting highest product of 3 numbers requires at least 3 numbers");
        }

        // we're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(intArray[0], intArray[1]);
        int lowest = Math.min(intArray[0], intArray[1]);

        int highestProductOf2 = intArray[0] * intArray[1];
        int lowestProductOf2 = intArray[0] * intArray[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = intArray[0] * intArray[1] * intArray[2];

        // walk through items, starting at index 2
        for(int i=2; i< intArray.length; i++){
            int current = intArray[i];

            // do we have a new highest product of 3?
            // it's either the current highestProductOf3,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2),current * lowestProductOf2);

            // do we have a new highest product of two?
            // it's either the current highestProductOf2,
            // or the current times the highest
            // or the current times the lowest
            highestProductOf2 = Math.max(Math.max(highestProductOf2, current * highest),current * lowest);

            // do we have a new lowest product of two?
            // it's either the current lowestProductOf2,
            // or the current times the highest
            // or the current times the lowest
            lowestProductOf2 = Math.min(Math.min(lowestProductOf2, current * highest), current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);

        }
        return highestProductOf3;
    }



    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MaxProductOf3Numbers.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}