package com.test.ctcigayle.IsUnique;

import com.source.ctcigayle.IsUnique.IsUnique_NoSpace;
import com.source.ctcigayle.IsUnique.IsUnique_UsingHashMap;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IsUnique_NoSpace_Test {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        assertEquals(true, IsUnique_NoSpace.checkIfUnique("abcde"));
        assertEquals(true, IsUnique_NoSpace.checkIfUnique(""));
        assertEquals(false, IsUnique_NoSpace.checkIfUnique("   "));
        assertEquals(false, IsUnique_NoSpace.checkIfUnique("abcade"));
        assertEquals(false, IsUnique_NoSpace.checkIfUnique("aaaaaa"));
        assertEquals(true, IsUnique_NoSpace.checkIfUnique("cat%^*"));
        assertEquals(false, IsUnique_NoSpace.checkIfUnique("catistrong"));
        assertEquals(false, IsUnique_NoSpace.checkIfUnique("catis_strong"));
    }
}
