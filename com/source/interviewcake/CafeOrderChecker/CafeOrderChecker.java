package com.source.interviewcake.CafeOrderChecker;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class CafeOrderChecker {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        // check if we're serving orders first-come, first-served

        int takeoutIndex = 0;
        int dineInIndex = 0;

        for(int i=0;i<servedOrders.length;i++){
            if(takeoutIndex < takeOutOrders.length && servedOrders[i] == takeOutOrders[takeoutIndex]){
                takeoutIndex++;
            }else if(dineInIndex < dineInOrders.length && servedOrders[i] == dineInOrders[dineInIndex]){
                dineInIndex++;
            }else{
                return false;
            }
        }

        // check for any extra orders at the end of takeOutOrders or dineInOrders
        if (dineInIndex != dineInOrders.length || takeoutIndex != takeOutOrders.length) {
            return false;
        }

        return true;
    }


















    // tests

    @Test
    public void bothRegistersHaveSameNumberOfOrdersTest() {
        final int[] takeOutOrders = {1, 4, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 4, 5, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void registersHaveDifferentLengthsTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterIsEmptyTest() {
        final int[] takeOutOrders = {};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {2, 3, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void servedOrdersIsMissingOrdersTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void servedOrdersHasExtraOrders() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 5, 6, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterHasExtraOrders() {
        final int[] takeOutOrders = {1, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }


    @Test
    public void oneRegisterHasUnservedOrders() {
        final int[] takeOutOrders = {55, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8, 9};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void orderNumbersAreNotSequential() {
        final int[] takeOutOrders = {27, 12, 18};
        final int[] dineInOrders = {55, 31, 8};
        final int[] servedOrders = {55, 31, 8, 27, 12, 18};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CafeOrderChecker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
