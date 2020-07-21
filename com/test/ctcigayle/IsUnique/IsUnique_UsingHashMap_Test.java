package com.test.ctcigayle.IsUnique;

import com.source.ctcigayle.IsUnique.IsUnique_UsingHashMap;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IsUnique_UsingHashMap_Test {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        assertEquals(true, IsUnique_UsingHashMap.checkIfUnique("abcde"));
        assertEquals(true, IsUnique_UsingHashMap.checkIfUnique(""));
        assertEquals(false, IsUnique_UsingHashMap.checkIfUnique("   "));
        assertEquals(false, IsUnique_UsingHashMap.checkIfUnique("abcade"));
        assertEquals(false, IsUnique_UsingHashMap.checkIfUnique("aaaaaa"));
        assertEquals(true, IsUnique_UsingHashMap.checkIfUnique("cat%^*"));
        assertEquals(false, IsUnique_UsingHashMap.checkIfUnique("catistrong"));
        assertEquals(false, IsUnique_UsingHashMap.checkIfUnique("catis_strong"));
    }
}
