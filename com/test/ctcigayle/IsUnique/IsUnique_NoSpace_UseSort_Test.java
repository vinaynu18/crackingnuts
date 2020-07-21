package com.test.ctcigayle.IsUnique;

import com.source.ctcigayle.IsUnique.IsUnique_NoSpace_UseSort;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IsUnique_NoSpace_UseSort_Test {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        assertEquals(true, IsUnique_NoSpace_UseSort.checkIfUnique("abcde"));
        assertEquals(true, IsUnique_NoSpace_UseSort.checkIfUnique(""));
        assertEquals(false, IsUnique_NoSpace_UseSort.checkIfUnique("   "));
        assertEquals(false, IsUnique_NoSpace_UseSort.checkIfUnique("abcade"));
        assertEquals(false, IsUnique_NoSpace_UseSort.checkIfUnique("aaaaaa"));
        assertEquals(true, IsUnique_NoSpace_UseSort.checkIfUnique("cat%^*"));
        assertEquals(false, IsUnique_NoSpace_UseSort.checkIfUnique("catistrong"));
        assertEquals(false, IsUnique_NoSpace_UseSort.checkIfUnique("catis_strong"));
    }
}
