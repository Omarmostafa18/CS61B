package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesNotSimple() {
        IntList lst = IntList.of(1, 1, 88, 100, 4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 1 -> 88 -> 100 -> 4", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimesWithPrimes() {
        IntList lst = IntList.of(17, 1, 88, 105, 3);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("289 -> 1 -> 88 -> 105 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesWithoutPrimes() {
        IntList lst = IntList.of(999, 1, 88, 100, 4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("999 -> 1 -> 88 -> 100 -> 4", lst.toString());
        assertFalse(changed);
    }
}